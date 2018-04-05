using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Configuration; //For connecting to db
using System.Data.SqlClient; //For SQL

namespace Retail_Distibution
{
    public partial class ProductsSetForDistribution : Form
    {
        public ProductsSetForDistribution()
        {
            InitializeComponent();
        }

        DataTable dt = new DataTable("Products");

        private void ProductsSetForDistribution_Load(object sender, EventArgs e)
        {
            try
            {
                using (SqlConnection cxn = new SqlConnection(ConfigurationManager.ConnectionStrings["Retail_Distibution.Properties.Settings.DistrubutionManagerDBConnectionString"].ConnectionString))
                {
                    if (cxn.State == ConnectionState.Closed)
                        cxn.Open();
                    SqlDataAdapter da = new SqlDataAdapter("Select * From ProductsSetForDistrib", cxn);
                    using (da)
                    {
                        da.Fill(dt);
                        dataGridView1.DataSource = dt;
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Message", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }

        //Search Button
        private void searchDistribution_Click(object sender, EventArgs e)
        {

            //Get String from textbox
            String searchText = searchDistribText.Text;
            Boolean isNumber = false;
            //Check if search was Int or string
            int num;//any int
            if (int.TryParse(searchText, out num))
            {
                //it is a number
                isNumber = true;
            }
            else
            {
                isNumber = false;
            }

            //IF NUMERIC
            if (isNumber == true)
            {
                //Get Data View
                DataView dv = dt.DefaultView;
                //Search through rows
                dv.RowFilter = string.Format("id = {0}", Convert.ToInt64(searchText));
                //Change table to this
                dataGridView1.DataSource = dv.ToTable();
            }
            else //If no value does pattern search and brings back to normal
            {
                //Get Data View
                DataView dv = dt.DefaultView;
                //Search through rows
                dv.RowFilter = string.Format("ProductName LIKE '%{0}%'", searchText);
                //Change table to this
                dataGridView1.DataSource = dv.ToTable();
 
            }


        }

        

        private void label1_Click(object sender, EventArgs e)
        {

        }
        

        //Back Button For main Screen
        private void backToMainScreen_Click(object sender, EventArgs e)
        {
            //Go back to main Screen
            DistributionMainScreen f1 = new DistributionMainScreen();
            f1.Show();
            //Now Delete Current Screen
            this.Close();
            
        }

        private void searchDistribText_TextChanged(object sender, EventArgs e)
        {

        }

        private void toSearchItems_Click(object sender, EventArgs e)
        {
            searchItems f1 = new searchItems();
            f1.Show();
            //Now delete current Screen
            this.Close();
        }


    }
}
