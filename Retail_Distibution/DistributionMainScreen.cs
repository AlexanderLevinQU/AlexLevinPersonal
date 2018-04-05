using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Retail_Distibution
{
    public partial class DistributionMainScreen : Form
    {
        public DistributionMainScreen()
        {
            InitializeComponent();
        }

        private void searchItems_Click(object sender, EventArgs e)
        {
            //Open New Form
            searchItems f1 = new searchItems();
            f1.Show();
            //Now Hide Current form
            this.Hide();
           
        }

        private void viewItemsForDistrib_Click(object sender, EventArgs e)
        {
            //Open new ProductDistrib form
            ProductsSetForDistribution f1 = new ProductsSetForDistribution();
            f1.Show();
            //Now delete current form
            this.Hide();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
