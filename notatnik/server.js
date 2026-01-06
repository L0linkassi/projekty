const express = require("express")
const path = require("path")
const fs = require("fs")
const bodyParser = require("body-parser")

const app = express()
const PORT = 3000

// Ścieżka do folderu notatek
const notesDirectory = path.join(__dirname, "notes")
console.log("Notes directory:", notesDirectory)

// Middleware do obsługi JSON
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: true }))

// Upewnijmy się, że folder notatek istnieje
if (!fs.existsSync(notesDirectory)) {
  fs.mkdirSync(notesDirectory)
  console.log("Created notes directory")
}
// Ensure category folders exist
;["szkola", "praca", "dom"].forEach((category) => {
  const categoryPath = path.join(notesDirectory, category)
  if (!fs.existsSync(categoryPath)) {
    fs.mkdirSync(categoryPath, { recursive: true })
    console.log(`Created category directory: ${category}`)
  }
})

// Custom middleware to set correct MIME types
app.use((req, res, next) => {
  if (req.url.endsWith(".js")) {
    res.setHeader("Content-Type", "application/javascript")
  }
  next()
})

// Serwowanie plików statycznych
app.use(express.static(__dirname))

// Strona główna
app.get("/", (req, res) => {
  res.sendFile(path.join(__dirname, "index.html"))
})

// Explicitly serve the script file
app.get("/script-fixed.js", (req, res) => {
  res.setHeader("Content-Type", "application/javascript")
  res.sendFile(path.join(__dirname, "script-fixed.js"))
})

// Tworzenie notatki w wybranej kategorii
app.post("/notes", (req, res) => {
  console.log("POST /notes request received:", req.body)

  const { title, content, category } = req.body
  if (!title || !content || !category) {
    console.log("Missing required fields")
    return res.status(400).json({ error: "Wszystkie pola są wymagane" })
  }

  const categoryPath = path.join(notesDirectory, category)
  if (!fs.existsSync(categoryPath)) {
    fs.mkdirSync(categoryPath, { recursive: true })
    console.log(`Created category directory: ${category}`)
  }

  const notePath = path.join(categoryPath, `${title}.txt`)

  // Check if note already exists
  if (fs.existsSync(notePath)) {
    console.log(`Note already exists: ${notePath}`)
    return res.status(400).json({ error: "Notatka o tej nazwie już istnieje" })
  }

  try {
    fs.writeFileSync(notePath, content, "utf8")
    console.log(`Note created: ${notePath}`)
    res.json({ message: "Notatka zapisana!", path: notePath })
  } catch (error) {
    console.error("Error creating note:", error)
    res.status(500).json({ error: "Błąd przy zapisywaniu notatki" })
  }
})

// Edytowanie istniejącej notatki
app.put("/notes/:category/:title", (req, res) => {
  console.log("PUT /notes request received:", req.params, req.body)

  const { category, title } = req.params
  const { content, title: newTitle, category: newCategory } = req.body

  if (!content || !newTitle || !newCategory) {
    console.log("Missing required fields")
    return res.status(400).json({ error: "Wszystkie pola są wymagane" })
  }

  const oldPath = path.join(notesDirectory, category, `${title}.txt`)

  // Check if the original note exists
  if (!fs.existsSync(oldPath)) {
    console.log(`Original note not found: ${oldPath}`)
    return res.status(404).json({ error: "Notatka nie istnieje" })
  }

  try {
    // If the category or title changed, we need to move the file
    if (category !== newCategory || title !== newTitle) {
      const newCategoryPath = path.join(notesDirectory, newCategory)

      // Create the new category directory if it doesn't exist
      if (!fs.existsSync(newCategoryPath)) {
        fs.mkdirSync(newCategoryPath, { recursive: true })
        console.log(`Created new category directory: ${newCategory}`)
      }

      const newPath = path.join(newCategoryPath, `${newTitle}.txt`)

      // Check if a note with the new title already exists in the new category
      if (fs.existsSync(newPath) && (category !== newCategory || title !== newTitle)) {
        console.log(`Note with new title already exists: ${newPath}`)
        return res.status(400).json({ error: "Notatka o tej nazwie już istnieje w wybranej kategorii" })
      }

      // Write the content to the new file
      fs.writeFileSync(newPath, content, "utf8")
      console.log(`New note created: ${newPath}`)

      // Delete the old file
      fs.unlinkSync(oldPath)
      console.log(`Old note deleted: ${oldPath}`)
    } else {
      // Just update the content if title and category didn't change
      fs.writeFileSync(oldPath, content, "utf8")
      console.log(`Note updated: ${oldPath}`)
    }

    res.json({ message: "Notatka zaktualizowana!" })
  } catch (error) {
    console.error("Error updating note:", error)
    res.status(500).json({ error: "Błąd przy aktualizacji notatki" })
  }
})

// Pobieranie wszystkich notatek ze wszystkich kategorii
app.get("/notes", (req, res) => {
  console.log("GET /notes request received")
  const categories = ["szkola", "praca", "dom"]
  let allNotes = []

  try {
    categories.forEach((category) => {
      const categoryPath = path.join(notesDirectory, category)

      if (fs.existsSync(categoryPath)) {
        const files = fs.readdirSync(categoryPath)
        console.log(`Found ${files.length} notes in category ${category}`)

        const categoryNotes = files
          .map((file) => {
            const filePath = path.join(categoryPath, file)
            try {
              const content = fs.readFileSync(filePath, "utf8")
              return {
                title: file.replace(".txt", ""),
                content: content,
                category: category,
                filename: `${category}/${file}`,
              }
            } catch (err) {
              console.error(`Error reading file ${filePath}:`, err)
              return null
            }
          })
          .filter((note) => note !== null)

        allNotes = [...allNotes, ...categoryNotes]
      }
    })

    console.log(`Returning ${allNotes.length} notes total`)
    res.json(allNotes)
  } catch (error) {
    console.error("Error loading notes:", error)
    res.status(500).json({ error: "Błąd przy pobieraniu notatek" })
  }
})

// Pobieranie notatek z wybranej kategorii
app.get("/notes/:category", (req, res) => {
  const category = req.params.category
  console.log(`GET /notes/${category} request received`)

  const categoryPath = path.join(notesDirectory, category)

  if (!fs.existsSync(categoryPath)) {
    console.log(`Category not found: ${category}`)
    return res.status(404).json({ error: "Kategoria nie istnieje" })
  }

  try {
    const files = fs.readdirSync(categoryPath)
    console.log(`Found ${files.length} notes in category ${category}`)

    const notes = files.map((file) => ({
      title: file.replace(".txt", ""),
      content: fs.readFileSync(path.join(categoryPath, file), "utf8"),
      category: category,
    }))

    res.json(notes)
  } catch (error) {
    console.error(`Error getting notes for category ${category}:`, error)
    res.status(500).json({ error: "Błąd przy pobieraniu notatek" })
  }
})

// Usuwanie notatki
app.delete("/notes/:category/:filename", (req, res) => {
  const { category, filename } = req.params
  console.log(`DELETE /notes/${category}/${filename} request received`)

  const filePath = path.join(notesDirectory, category, filename)
  console.log(`Attempting to delete: ${filePath}`)

  fs.access(filePath, fs.constants.F_OK, (err) => {
    if (err) {
      console.log(`Note not found: ${filePath}`)
      return res.status(404).send("Notatka nie istnieje.")
    }

    fs.unlink(filePath, (err) => {
      if (err) {
        console.error(`Error deleting note: ${filePath}`, err)
        return res.status(500).send("Błąd przy usuwaniu notatki.")
      }
      console.log(`Note deleted: ${filePath}`)
      res.send("Notatka usunięta.")
    })
  })
})

// Uruchomienie serwera
app.listen(PORT, () => {
  console.log(`✅ Serwer działa na http://localhost:${PORT}`)
})

