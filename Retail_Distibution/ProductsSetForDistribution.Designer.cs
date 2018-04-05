namespace Retail_Distibution
{
    partial class ProductsSetForDistribution
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
            this.productsSetForDistribBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.distrubutionManagerDBDataSet = new Retail_Distibution.DistrubutionManagerDBDataSet();
            this.searchDistribution = new System.Windows.Forms.Button();
            this.searchDistribText = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.backToMainScreen = new System.Windows.Forms.Button();
            this.toSearchItems = new System.Windows.Forms.Button();
            this.productsSetForDistribTableAdapter = new Retail_Distibution.DistrubutionManagerDBDataSetTableAdapters.ProductsSetForDistribTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.productsSetForDistribBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(12, 75);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(1044, 468);
            this.dataGridView1.TabIndex = 0;
            // 
            // productsSetForDistribBindingSource
            // 
            this.productsSetForDistribBindingSource.DataMember = "ProductsSetForDistrib";
            this.productsSetForDistribBindingSource.DataSource = this.distrubutionManagerDBDataSet;
            // 
            // distrubutionManagerDBDataSet
            // 
            this.distrubutionManagerDBDataSet.DataSetName = "DistrubutionManagerDBDataSet";
            this.distrubutionManagerDBDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // searchDistribution
            // 
            this.searchDistribution.Location = new System.Drawing.Point(12, 46);
            this.searchDistribution.Name = "searchDistribution";
            this.searchDistribution.Size = new System.Drawing.Size(75, 23);
            this.searchDistribution.TabIndex = 1;
            this.searchDistribution.Text = "Search";
            this.searchDistribution.UseVisualStyleBackColor = true;
            this.searchDistribution.Click += new System.EventHandler(this.searchDistribution_Click);
            // 
            // searchDistribText
            // 
            this.searchDistribText.Location = new System.Drawing.Point(93, 49);
            this.searchDistribText.Name = "searchDistribText";
            this.searchDistribText.Size = new System.Drawing.Size(237, 20);
            this.searchDistribText.TabIndex = 2;
            this.searchDistribText.TextChanged += new System.EventHandler(this.searchDistribText_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(174, 33);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(64, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "SearchByID";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // backToMainScreen
            // 
            this.backToMainScreen.Location = new System.Drawing.Point(350, 46);
            this.backToMainScreen.Name = "backToMainScreen";
            this.backToMainScreen.Size = new System.Drawing.Size(75, 23);
            this.backToMainScreen.TabIndex = 4;
            this.backToMainScreen.Text = "Main Screen";
            this.backToMainScreen.UseVisualStyleBackColor = true;
            this.backToMainScreen.Click += new System.EventHandler(this.backToMainScreen_Click);
            // 
            // toSearchItems
            // 
            this.toSearchItems.Location = new System.Drawing.Point(443, 46);
            this.toSearchItems.Name = "toSearchItems";
            this.toSearchItems.Size = new System.Drawing.Size(118, 23);
            this.toSearchItems.TabIndex = 5;
            this.toSearchItems.Text = "toSearchItems";
            this.toSearchItems.UseVisualStyleBackColor = true;
            this.toSearchItems.Click += new System.EventHandler(this.toSearchItems_Click);
            // 
            // productsSetForDistribTableAdapter
            // 
            this.productsSetForDistribTableAdapter.ClearBeforeFill = true;
            // 
            // ProductsSetForDistribution
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1236, 552);
            this.Controls.Add(this.toSearchItems);
            this.Controls.Add(this.backToMainScreen);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.searchDistribText);
            this.Controls.Add(this.searchDistribution);
            this.Controls.Add(this.dataGridView1);
            this.Name = "ProductsSetForDistribution";
            this.Text = "z";
            this.Load += new System.EventHandler(this.ProductsSetForDistribution_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.productsSetForDistribBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.distrubutionManagerDBDataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button searchDistribution;
        private System.Windows.Forms.TextBox searchDistribText;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button backToMainScreen;
        private System.Windows.Forms.Button toSearchItems;
        private DistrubutionManagerDBDataSet distrubutionManagerDBDataSet;
        private System.Windows.Forms.BindingSource productsSetForDistribBindingSource;
        private DistrubutionManagerDBDataSetTableAdapters.ProductsSetForDistribTableAdapter productsSetForDistribTableAdapter;
    }
}