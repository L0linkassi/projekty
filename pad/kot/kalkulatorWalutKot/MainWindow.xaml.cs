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

namespace kalkulatorWalutKot
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }
        private void PrzeliczButton_Click(object sender, RoutedEventArgs e)
        {
            if (!double.TryParse(kwotaa.Text, out double kwota))
            {
                MessageBox.Show("Wprowadź poprawną kwotę.", "Błąd", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            string JakaWaluta = ((ComboBoxItem)JakaWaluta.SelectedItem)?.Content.ToString();
            string NaJakaWalute = ((ComboBoxItem)NaJakaWalute.SelectedItem)?.Content.ToString();

            if (zwaluty == null || nawalute == null)
            {
                MessageBox.Show("Wybierz waluty.", "Błąd", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }

            double przelicznik = 1.0;
            double naprzelicz = 1.0;

            if (JakaWaluta == "EUR") przelicznik = 4.30;
            if (JakaWaluta == "USD") przelicznik = 4.00;

            if (NaJakaWalute == "EUR") przelicznik = 4.30;
            if (NaJakaWalute == "USD") przelicznik = 4.00;

            double result = kwota * przelicznik / naprzelicz;

            Wynik.Text = $"Wynik: {result:F2} {nawalute}";
        }

    }
}