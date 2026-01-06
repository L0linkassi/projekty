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

namespace KotKalkulatorWalut
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void countbtn_Click_1(object sender, RoutedEventArgs e)
        {
            //walidacja
            if (string.IsNullOrEmpty(kwotaTextbox.Text))
            {
                MessageBox.Show("Proszę podać kwotę", "Błąd walidacji", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }
            //pobieranie danych i zapisanie do zmiennej
            double kwota = 0;
            try
            {
                kwota = Convert.ToDouble(kwotaTextbox.Text);
                string zwaluty = (zWaluty.SelectedItem as System.Windows.Controls.ComboBoxItem)?.Content.ToString();
                string nawalute = (naWalute.SelectedItem as System.Windows.Controls.ComboBoxItem)?.Content.ToString();

                double wynik = PrzeliczWalute(kwota, zwaluty, nawalute);

                labelW.Content = $"Wynik: {wynik}";
            }
            catch
            {
                MessageBox.Show("Używaj tylko cyfr!", "Błąd walidacji", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }
        }
        //przeliczanie
        private double PrzeliczWalute(double kwota, string z, string na)
        {
            double eur = 4.30;
            double usd = 4.00;


            double kwotaWPLN = z switch
            {
                "PLN" => kwota,
                "EUR" => kwota * eur,
                "USD" => kwota * usd,
                _ => 0
            };


            return na switch
            {
                "PLN" => kwotaWPLN,
                "EUR" => kwotaWPLN / eur,
                "USD" => kwotaWPLN / usd,
                _ => 0
            };
        }
    }
}