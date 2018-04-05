namespace Retail_Distibution
{
    partial class searchItems
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.shelvedItemsBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.distrubutionManagerDBDataSet1 = new Retail_Distibution.DistrubutionManagerDBDataSet1();
            this.searchProductsInStorage = new System.Windows.Forms.Button();
            this.searchText = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.addProduct = new System.Windows.Forms.Button();
            this.productId = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.backToMainScreen = new System.Windows.Forms.Button();
            this.viewProductDistribution = new System.Windows.Forms.Button();
            this.distrubutionManagerDBDataSet = new Retail_Distibution.DistrubutionManagerDBDataSet();
            this.distrubutionManagerDBDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.shelvedItemsTableAdapter = new Retail_Distibution.DistrubutionManagerDBDataSet1TableAdapters.shelvedItemsTableAdapter();
            this.cityDestination = new System.Windows.Forms.Label();
            this.stateDestination = new System.Windows.Forms.Label();
            this.cityDestTextBox = new System.Windows.Forms.TextBox();
            this.stateDestTextBox = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.shelvedItemsBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSet1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSet)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSetBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(21, 66);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(743, 489);
            this.dataGridView1.TabIndex = 0;
            // 
            // shelvedItemsBindingSource
            // 
            this.shelvedItemsBindingSource.DataMember = "shelvedItems";
            this.shelvedItemsBindingSource.DataSource = this.distrubutionManagerDBDataSet1;
            // 
            // distrubutionManagerDBDataSet1
            // 
            this.distrubutionManagerDBDataSet1.DataSetName = "DistrubutionManagerDBDataSet1";
            this.distrubutionManagerDBDataSet1.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // searchProductsInStorage
            // 
            this.searchProductsInStorage.Location = new System.Drawing.Point(21, 22);
            this.searchProductsInStorage.Name = "searchProductsInStorage";
            this.searchProductsInStorage.Size = new System.Drawing.Size(91, 23);
            this.searchProductsInStorage.TabIndex = 1;
            this.searchProductsInStorage.Text = "Search";
            this.searchProductsInStorage.UseVisualStyleBackColor = true;
            this.searchProductsInStorage.Click += new System.EventHandler(this.searchProductsInStorage_Click);
            // 
            // searchText
            // 
            this.searchText.Location = new System.Drawing.Point(118, 24);
            this.searchText.Name = "searchText";
            this.searchText.Size = new System.Drawing.Size(300, 20);
            this.searchText.TabIndex = 2;
            this.searchText.TextChanged += new System.EventHandler(this.searchText_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(174, 5);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(126, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Search by Product Name";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // addProduct
            // 
            this.addProduct.Location = new System.Drawing.Point(829, 103);
            this.addProduct.Name = "addProduct";
            this.addProduct.Size = new System.Drawing.Size(258, 23);
            this.addProduct.TabIndex = 5;
            this.addProduct.Text = "Add";
            this.addProduct.UseVisualStyleBackColor = true;
            this.addProduct.Click += new System.EventHandler(this.addProduct_Click);
            // 
            // productId
            // 
            this.productId.Location = new System.Drawing.Point(887, 145);
            this.productId.Name = "productId";
            this.productId.Size = new System.Drawing.Size(140, 20);
            this.productId.TabIndex = 13;
            this.productId.TextChanged += new System.EventHandler(this.productId_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(884, 76);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(143, 13);
            this.label2.TabIndex = 14;
            this.label2.Text = "Add Product For Distrubution";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(915, 129);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(86, 13);
            this.label3.TabIndex = 15;
            this.label3.Text = "Enter Product ID";
            // 
            // backToMainScreen
            // 
            this.backToMainScreen.Location = new System.Drawing.Point(918, 291);
            this.backToMainScreen.Name = "backToMainScreen";
            this.backToMainScreen.Size = new System.Drawing.Size(75, 23);
            this.backToMainScreen.TabIndex = 16;
            this.backToMainScreen.Text = "MainScreen";
            this.backToMainScreen.UseVisualStyleBackColor = true;
            this.backToMainScreen.Click += new System.EventHandler(this.backToMainScreen_Click);
            // 
            // viewProductDistribution
            // 
            this.viewProductDistribution.Location = new System.Drawing.Point(918, 345);
            this.viewProductDistribution.Name = "viewProductDistribution";
            this.viewProductDistribution.Size = new System.Drawing.Size(75, 55);
            this.viewProductDistribution.TabIndex = 17;
            this.viewProductDistribution.Text = "View Product Distribution";
            this.viewProductDistribution.UseVisualStyleBackColor = true;
            this.viewProductDistribution.Click += new System.EventHandler(this.viewProductDistribution_Click);
            // 
            // distrubutionManagerDBDataSet
            // 
            this.distrubutionManagerDBDataSet.DataSetName = "DistrubutionManagerDBDataSet";
            this.distrubutionManagerDBDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // distrubutionManagerDBDataSetBindingSource
            // 
            this.distrubutionManagerDBDataSetBindingSource.DataSource = this.distrubutionManagerDBDataSet;
            this.distrubutionManagerDBDataSetBindingSource.Position = 0;
            // 
            // shelvedItemsTableAdapter
            // 
            this.shelvedItemsTableAdapter.ClearBeforeFill = true;
            // 
            // cityDestination
            // 
            this.cityDestination.AutoSize = true;
            this.cityDestination.Location = new System.Drawing.Point(808, 185);
            this.cityDestination.Name = "cityDestination";
            this.cityDestination.Size = new System.Drawing.Size(108, 13);
            this.cityDestination.TabIndex = 18;
            this.cityDestination.Text = "Enter City Destination";
            // 
            // stateDestination
            // 
            this.stateDestination.AutoSize = true;
            this.stateDestination.Location = new System.Drawing.Point(996, 185);
            this.stateDestination.Name = "stateDestination";
            this.stateDestination.Size = new System.Drawing.Size(116, 13);
            this.stateDestination.TabIndex = 19;
            this.stateDestination.Text = "Enter State Destination";
            this.stateDestination.Click += new System.EventHandler(this.stateDestination_Click);
            // 
            // cityDestTextBox
            // 
            this.cityDestTextBox.Location = new System.Drawing.Point(811, 214);
            this.cityDestTextBox.Name = "cityDestTextBox";
            this.cityDestTextBox.Size = new System.Drawing.Size(100, 20);
            this.cityDestTextBox.TabIndex = 20;
            // 
            // stateDestTextBox
            // 
            this.stateDestTextBox.Location = new System.Drawing.Point(999, 214);
            this.stateDestTextBox.Name = "stateDestTextBox";
            this.stateDestTextBox.Size = new System.Drawing.Size(100, 20);
            this.stateDestTextBox.TabIndex = 21;
            // 
            // searchItems
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1124, 567);
            this.Controls.Add(this.stateDestTextBox);
            this.Controls.Add(this.cityDestTextBox);
            this.Controls.Add(this.stateDestination);
            this.Controls.Add(this.cityDestination);
            this.Controls.Add(this.viewProductDistribution);
            this.Controls.Add(this.backToMainScreen);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.productId);
            this.Controls.Add(this.addProduct);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.searchText);
            this.Controls.Add(this.searchProductsInStorage);
            this.Controls.Add(this.dataGridView1);
            this.Name = "searchItems";
            this.Text = "searchItems";
            this.Load += new System.EventHandler(this.searchItems_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.shelvedItemsBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSet1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSet)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSetBindingSource)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button searchProductsInStorage;
        private System.Windows.Forms.TextBox searchText;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button addProduct;
        private System.Windows.Forms.TextBox productId;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button backToMainScreen;
        private System.Windows.Forms.Button viewProductDistribution;
        private System.Windows.Forms.BindingSource distrubutionManagerDBDataSetBindingSource;
        private DistrubutionManagerDBDataSet distrubutionManagerDBDataSet;
        private DistrubutionManagerDBDataSet1 distrubutionManagerDBDataSet1;
        private System.Windows.Forms.BindingSource shelvedItemsBindingSource;
        private DistrubutionManagerDBDataSet1TableAdapters.shelvedItemsTableAdapter shelvedItemsTableAdapter;
        private System.Windows.Forms.Label cityDestination;
        private System.Windows.Forms.Label stateDestination;
        private System.Windows.Forms.TextBox cityDestTextBox;
        private System.Windows.Forms.TextBox stateDestTextBox;
    }
}