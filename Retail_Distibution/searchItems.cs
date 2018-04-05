using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Configuration;

namespace Retail_Distibution
{
    public partial class searchItems : Form
    {
        DataTable dt = new DataTable("Shelved Items");
        public searchItems()
        {
            InitializeComponent();
        }

        private void searchItems_Load(object sender, EventArgs e)
        {
            try
            {
                using (SqlConnection cxn = new SqlConnection(ConfigurationManager.ConnectionStrings["Retail_Distibution.Properties.Settings.DistrubutionManagerDBConnectionString"].ConnectionString))
                {
                    if (cxn.State == ConnectionState.Closed)
                        cxn.Open();
                    SqlDataAdapter da = new SqlDataAdapter("Select * From shelvedItems", cxn);
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

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }
        //Search Button
        private void searchProductsInStorage_Click(object sender, EventArgs e)
        {
            //Get String from textbox
            String theSearchText = searchText.Text;
            Boolean isNumber = false;
            //Check if search was Int or string
            int num;//any int
            if (int.TryParse(theSearchText, out num))
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
                dv.RowFilter = string.Format("id = {0}", Convert.ToInt64(theSearchText));
                //Change table to this
                dataGridView1.DataSource = dv.ToTable();

            }
            else
            {
                //Search through rows
                //Get Data View
                DataView dv = dt.DefaultView;
                //Search through rows
                dv.RowFilter = string.Format("ProductName LIKE '%{0}%'", theSearchText);
                //Change table to this
                dataGridView1.DataSource = dv.ToTable();
            }
            
        }
        //Add button
        private void addProduct_Click(object sender, EventArgs e)
        {
            //Create Strings for adding for later
            String cCity = "";
            String cState = "";
            String type = "";
            String price = "";
            String buyer = "Mystery Buyer";
            String productName = "";
            String shelvedID = "";

            //First query the Product ID entered to get all the values
            try
            {
                using (SqlConnection cxn = new SqlConnection(ConfigurationManager.ConnectionStrings["Retail_Distibution.Properties.Settings.DistrubutionManagerDBConnectionString"].ConnectionString))
                {
                    if (cxn.State == ConnectionState.Closed)
                        cxn.Open();
                    String findQuery = string.Format("Select * From shelvedItems WHERE id = {0}", productId.Text);
                    SqlCommand cmd = new SqlCommand(findQuery, cxn);
                    using (cmd)
                    {
                        //Now query
                        using(SqlDataReader dr = cmd.ExecuteReader())
                        {
                            //Collect data and update strings
                            //Only loops once 
                            while (dr.Read())
                            {
                                shelvedID = dr[0].ToString();
                                productName = dr[1].ToString();
                                cCity = dr[2].ToString();
                                cState = dr[3].ToString();
                                type = dr[4].ToString();
                                price = dr[5].ToString();
                            }
                        }
                    }
                    cxn.Dispose();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Message", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

            //Then Construct new query from that
            String query = "INSERT INTO ProductsSetForDistrib([ProductName], [currentCity], [currentLocation],[Type],[Price],[Buyer],[cityToBeDistrubted],[stateToBeDistrubted],[shelvedId]) VALUES(@pName, @cCity, @cState, @type, @price, @buyer, @ctbDistrubted, @stbDistributed, @shelvedId)";
            //Now add To other table
            try
            {
                using (SqlConnection cxn = new SqlConnection(ConfigurationManager.ConnectionStrings["Retail_Distibution.Properties.Settings.DistrubutionManagerDBConnectionString"].ConnectionString))
                {
                    if (cxn.State == ConnectionState.Closed)
                        cxn.Open();
                    using (SqlCommand cmd = new SqlCommand(query, cxn))
                    {
                        //Add the values into text
                        cmd.Parameters.AddWithValue("@cCity", cCity); //cCity
                        cmd.Parameters.AddWithValue("@cState", cState); //cState
                        cmd.Parameters.AddWithValue("@type", type); //Type
                        cmd.Parameters.AddWithValue("@price", Convert.ToDecimal(price)); //Price
                        cmd.Parameters.AddWithValue("@buyer", buyer); //Buyer
                        cmd.Parameters.AddWithValue("@ctbDistrubted", cityDestTextBox.Text); //cityToBeDistrubted
                        cmd.Parameters.AddWithValue("@stbDistributed", stateDestTextBox.Text); //stateToBeDistrubted
                        cmd.Parameters.AddWithValue("@shelvedId", shelvedID); //ShelveID
                        cmd.Parameters.AddWithValue("@pName", productName); //Product name

                        cmd.ExecuteNonQuery();

                        MessageBox.Show("Entry Added, In Distribution Process");

                    }
                    cxn.Dispose();
                    
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Message", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }


        }


        //Search Text
        private void searchText_TextChanged(object sender, EventArgs e)
        {

        }

        private void productId_TextChanged(object sender, EventArgs e)
        {

        }

        //To main Screen
        private void backToMainScreen_Click(object sender, EventArgs e)
        {
            //Create Main Screen
            DistributionMainScreen f1 = new DistributionMainScreen();
            f1.Show();
            //Hide current
            this.Hide();
        }

        //To Product Distrib Screen
        private void viewProductDistribution_Click(object sender, EventArgs e)
        {
            //Create ProductsDistrib Screen
            ProductsSetForDistribution f1 = new ProductsSetForDistribution();
            f1.Show();
            //Hide Current
            this.Hide();
        }

        private void stateDestination_Click(object sender, EventArgs e)
        {

        }

    }
}
