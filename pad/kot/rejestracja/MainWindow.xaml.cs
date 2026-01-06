using Microsoft.Win32;
using System.IO;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace rejestracja
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private StringBuilder StudentsData = new StringBuilder();
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Addbtn_Click(object sender, RoutedEventArgs e)
        {
            //walidacja
            if (string.IsNullOrEmpty(FirstNameTextbox.Text) || string.IsNullOrEmpty(LastNameTextbox.Text) || BirthDatepicker.SelectedDate == null || fieldOfStudies.SelectedItem == null)
            {
                MessageBox.Show("Proszę wypełnić wszystkie Pola", "Błąd walidacji", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }
            //akceptacja EULA
            if (EULAcheckbox.IsChecked == false)
            {
                MessageBox.Show("Akceptacja jest wymagana", "Blad walidacji", MessageBoxButton.OK, MessageBoxImage.Error);
            }
            //pobieranie danych i zapisanie do zmiennej
            string firstName = FirstNameTextbox.Text;
            string lastName = LastNameTextbox.Text;
            string birthDate = BirthDatepicker.SelectedDate.Value.ToString("dd-mm-yyyy");
            string fieldOfStudy = (fieldOfStudies.SelectedItem as ComboBoxItem).Content.ToString();
            bool newsletter = Newsletter.IsChecked == true;

            //tworzenie sformatowanego ciągu znakó z danymi studenta
            string studendInfo = $"Imie: {firstName}, Nazwisko: {lastName}, Data urodzenia: {birthDate}, Kierunek: {fieldOfStudy}, Newsletter: {(newsletter ? "Tak" : "Nie")}\n";

            //Dodajemy dane do zmiennej studentsData
            StudentsData.Append(studendInfo);
            MessageBox.Show("Student dodany do listy", "Success", MessageBoxButton.OK, MessageBoxImage.Information);

            //wyczysc formularz
            clearForm();

        }

        private void clearForm()
        {
            FirstNameTextbox.Clear();
            LastNameTextbox.Clear();
            BirthDatepicker.SelectedDate = null;
            fieldOfStudies.SelectedItem = null;
            EULAcheckbox.IsChecked = false;
            Newsletter.IsChecked = false;
        }

        private void Clearbtn_Click(object sender, RoutedEventArgs e)
        {
            clearForm();
        }

        private void Savebtn_Click(object sender, RoutedEventArgs e)
        {
            if (StudentsData.Length == 0)
            {
                MessageBox.Show("Brak danych do zapisania", "Informacja", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            //otwieramy konto dialogowe do zapipsu pliku
            SaveFileDialog saveFileDialog = new SaveFileDialog();

            saveFileDialog.FileName = "studenci.txt";
            saveFileDialog.Title = "Zapisz liste studentow";

            if (saveFileDialog.ShowDialog() == true)
            {
                try
                {
                    //zapisujemy calosc studensData (typ stringBuilder) so pliku
                    File.WriteAllText(saveFileDialog.FileName, StudentsData.ToString());

                    MessageBox.Show($"Dane zostaly pomyslnie zapisane w pliku\n {saveFileDialog.FileName}", "Plik zapisany", MessageBoxButton.OK, MessageBoxImage.Information);

                    StudentsData.Clear();
                }
                catch (IOException ex)
                {
                    {
                        MessageBox.Show($"Wystapil blad podczas zapisu pliku:  {ex.Message}", "Blad zapisu", MessageBoxButton.OK, MessageBoxImage.Error);
                    }
                }
            }


        }
    }
}