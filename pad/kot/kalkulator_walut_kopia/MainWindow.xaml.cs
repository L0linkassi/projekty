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

namespace kalkulator_walut
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

        private void clearbtn_Click(object sender, RoutedEventArgs e)
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
            }
            catch
            {
                MessageBox.Show("Używaj tylko cyfr!", "Błąd walidacji", MessageBoxButton.OK, MessageBoxImage.Warning);
                return;
            }
            //przeliczanie


        }

        

    }
}