namespace Retail_Distibution
{
    partial class DistributionMainScreen
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
            this.searchItems = new System.Windows.Forms.Button();
            this.viewItemsForDistrib = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // searchItems
            // 
            this.searchItems.Location = new System.Drawing.Point(82, 53);
            this.searchItems.Name = "searchItems";
            this.searchItems.Size = new System.Drawing.Size(131, 37);
            this.searchItems.TabIndex = 0;
            this.searchItems.Text = "Search and Add Items For Distribution";
            this.searchItems.UseVisualStyleBackColor = true;
            this.searchItems.Click += new System.EventHandler(this.searchItems_Click);
            // 
            // viewItemsForDistrib
            // 
            this.viewItemsForDistrib.Location = new System.Drawing.Point(82, 126);
            this.viewItemsForDistrib.Name = "viewItemsForDistrib";
            this.viewItemsForDistrib.Size = new System.Drawing.Size(131, 46);
            this.viewItemsForDistrib.TabIndex = 2;
            this.viewItemsForDistrib.Text = "View Products For Distrubution";
            this.viewItemsForDistrib.UseVisualStyleBackColor = true;
            this.viewItemsForDistrib.Click += new System.EventHandler(this.viewItemsForDistrib_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(88, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(108, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Distrubution Manager";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.viewItemsForDistrib);
            this.Controls.Add(this.searchItems);
            this.Name = "Distribution Manager Main Screen";
            this.Text = "MainScreen";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button searchItems;
        private System.Windows.Forms.Button viewItemsForDistrib;
        private System.Windows.Forms.Label label1;
    }
}

