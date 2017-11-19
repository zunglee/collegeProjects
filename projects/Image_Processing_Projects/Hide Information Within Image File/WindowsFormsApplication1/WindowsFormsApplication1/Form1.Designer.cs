namespace WindowsFormsApplication1
{
    partial class Form1
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
            this.EnImageBrowse_btn = new System.Windows.Forms.Button();
            this.EnFileBrowse_btn = new System.Windows.Forms.Button();
            this.DeLoadImageBrowse_btn = new System.Windows.Forms.Button();
            this.DeSaveFileBrowse_btn = new System.Windows.Forms.Button();
            this.EnImage_tbx = new System.Windows.Forms.TextBox();
            this.EnFile_tbx = new System.Windows.Forms.TextBox();
            this.DeLoadImage_tbx = new System.Windows.Forms.TextBox();
            this.DeSaveFile_tbx = new System.Windows.Forms.TextBox();
            this.ImageSize_lbl = new System.Windows.Forms.Label();
            this.ImageHeight_lbl = new System.Windows.Forms.Label();
            this.ImageWidth_lbl = new System.Windows.Forms.Label();
            this.CanSave_lbl = new System.Windows.Forms.Label();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.directoryEntry1 = new System.DirectoryServices.DirectoryEntry();
            this.openFileDialog2 = new System.Windows.Forms.OpenFileDialog();
            this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
            this.Encrypt_btn = new System.Windows.Forms.Button();
            this.toolStripStatusLabel1 = new System.Windows.Forms.Label();
            this.Decrypt_btn = new System.Windows.Forms.Button();
            this.openFileDialog3 = new System.Windows.Forms.OpenFileDialog();
            this.folderBrowserDialog1 = new System.Windows.Forms.FolderBrowserDialog();
            this.SuspendLayout();
            // 
            // EnImageBrowse_btn
            // 
            this.EnImageBrowse_btn.Location = new System.Drawing.Point(341, 12);
            this.EnImageBrowse_btn.Name = "EnImageBrowse_btn";
            this.EnImageBrowse_btn.Size = new System.Drawing.Size(75, 23);
            this.EnImageBrowse_btn.TabIndex = 0;
            this.EnImageBrowse_btn.Text = "browse1";
            this.EnImageBrowse_btn.UseVisualStyleBackColor = true;
            this.EnImageBrowse_btn.Click += new System.EventHandler(this.EnImageBrowse_btn_Click);
            // 
            // EnFileBrowse_btn
            // 
            this.EnFileBrowse_btn.Location = new System.Drawing.Point(341, 54);
            this.EnFileBrowse_btn.Name = "EnFileBrowse_btn";
            this.EnFileBrowse_btn.Size = new System.Drawing.Size(75, 23);
            this.EnFileBrowse_btn.TabIndex = 1;
            this.EnFileBrowse_btn.Text = "browse2";
            this.EnFileBrowse_btn.UseVisualStyleBackColor = true;
            this.EnFileBrowse_btn.Click += new System.EventHandler(this.EnFileBrowse_btn_Click);
            // 
            // DeLoadImageBrowse_btn
            // 
            this.DeLoadImageBrowse_btn.Location = new System.Drawing.Point(328, 163);
            this.DeLoadImageBrowse_btn.Name = "DeLoadImageBrowse_btn";
            this.DeLoadImageBrowse_btn.Size = new System.Drawing.Size(75, 23);
            this.DeLoadImageBrowse_btn.TabIndex = 2;
            this.DeLoadImageBrowse_btn.Text = "browse3";
            this.DeLoadImageBrowse_btn.UseVisualStyleBackColor = true;
            this.DeLoadImageBrowse_btn.Click += new System.EventHandler(this.DeLoadImageBrowse_btn_Click);
            // 
            // DeSaveFileBrowse_btn
            // 
            this.DeSaveFileBrowse_btn.Location = new System.Drawing.Point(328, 204);
            this.DeSaveFileBrowse_btn.Name = "DeSaveFileBrowse_btn";
            this.DeSaveFileBrowse_btn.Size = new System.Drawing.Size(75, 23);
            this.DeSaveFileBrowse_btn.TabIndex = 3;
            this.DeSaveFileBrowse_btn.Text = "browse4";
            this.DeSaveFileBrowse_btn.UseVisualStyleBackColor = true;
            this.DeSaveFileBrowse_btn.Click += new System.EventHandler(this.DeSaveFileBrowse_btn_Click);
            // 
            // EnImage_tbx
            // 
            this.EnImage_tbx.Location = new System.Drawing.Point(136, 15);
            this.EnImage_tbx.Name = "EnImage_tbx";
            this.EnImage_tbx.Size = new System.Drawing.Size(130, 20);
            this.EnImage_tbx.TabIndex = 4;
            // 
            // EnFile_tbx
            // 
            this.EnFile_tbx.Location = new System.Drawing.Point(136, 54);
            this.EnFile_tbx.Name = "EnFile_tbx";
            this.EnFile_tbx.Size = new System.Drawing.Size(130, 20);
            this.EnFile_tbx.TabIndex = 5;
            // 
            // DeLoadImage_tbx
            // 
            this.DeLoadImage_tbx.Location = new System.Drawing.Point(136, 166);
            this.DeLoadImage_tbx.Name = "DeLoadImage_tbx";
            this.DeLoadImage_tbx.Size = new System.Drawing.Size(130, 20);
            this.DeLoadImage_tbx.TabIndex = 6;
            // 
            // DeSaveFile_tbx
            // 
            this.DeSaveFile_tbx.Location = new System.Drawing.Point(136, 207);
            this.DeSaveFile_tbx.Name = "DeSaveFile_tbx";
            this.DeSaveFile_tbx.Size = new System.Drawing.Size(130, 20);
            this.DeSaveFile_tbx.TabIndex = 7;
            // 
            // ImageSize_lbl
            // 
            this.ImageSize_lbl.AutoSize = true;
            this.ImageSize_lbl.Location = new System.Drawing.Point(483, 22);
            this.ImageSize_lbl.Name = "ImageSize_lbl";
            this.ImageSize_lbl.Size = new System.Drawing.Size(35, 13);
            this.ImageSize_lbl.TabIndex = 8;
            this.ImageSize_lbl.Text = "label5";
            // 
            // ImageHeight_lbl
            // 
            this.ImageHeight_lbl.AutoSize = true;
            this.ImageHeight_lbl.Location = new System.Drawing.Point(483, 64);
            this.ImageHeight_lbl.Name = "ImageHeight_lbl";
            this.ImageHeight_lbl.Size = new System.Drawing.Size(35, 13);
            this.ImageHeight_lbl.TabIndex = 9;
            this.ImageHeight_lbl.Text = "label6";
            // 
            // ImageWidth_lbl
            // 
            this.ImageWidth_lbl.AutoSize = true;
            this.ImageWidth_lbl.Location = new System.Drawing.Point(483, 99);
            this.ImageWidth_lbl.Name = "ImageWidth_lbl";
            this.ImageWidth_lbl.Size = new System.Drawing.Size(35, 13);
            this.ImageWidth_lbl.TabIndex = 10;
            this.ImageWidth_lbl.Text = "label7";
            // 
            // CanSave_lbl
            // 
            this.CanSave_lbl.AutoSize = true;
            this.CanSave_lbl.Location = new System.Drawing.Point(483, 132);
            this.CanSave_lbl.Name = "CanSave_lbl";
            this.CanSave_lbl.Size = new System.Drawing.Size(35, 13);
            this.CanSave_lbl.TabIndex = 11;
            this.CanSave_lbl.Text = "label8";
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // openFileDialog2
            // 
            this.openFileDialog2.FileName = "openFileDialog2";
            // 
            // Encrypt_btn
            // 
            this.Encrypt_btn.Location = new System.Drawing.Point(136, 99);
            this.Encrypt_btn.Name = "Encrypt_btn";
            this.Encrypt_btn.Size = new System.Drawing.Size(75, 23);
            this.Encrypt_btn.TabIndex = 12;
            this.Encrypt_btn.Text = "ENCRYPT";
            this.Encrypt_btn.UseVisualStyleBackColor = true;
            this.Encrypt_btn.Click += new System.EventHandler(this.Encrypt_btn_Click);
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.AutoSize = true;
            this.toolStripStatusLabel1.Location = new System.Drawing.Point(217, 109);
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(35, 13);
            this.toolStripStatusLabel1.TabIndex = 13;
            this.toolStripStatusLabel1.Text = "label5";
            this.toolStripStatusLabel1.Click += new System.EventHandler(this.label5_Click);
            // 
            // Decrypt_btn
            // 
            this.Decrypt_btn.Location = new System.Drawing.Point(136, 249);
            this.Decrypt_btn.Name = "Decrypt_btn";
            this.Decrypt_btn.Size = new System.Drawing.Size(75, 23);
            this.Decrypt_btn.TabIndex = 14;
            this.Decrypt_btn.Text = "DECRYPT";
            this.Decrypt_btn.UseVisualStyleBackColor = true;
            this.Decrypt_btn.Click += new System.EventHandler(this.Decrypt_btn_Click);
            // 
            // openFileDialog3
            // 
            this.openFileDialog3.FileName = "openFileDialog3";
            // 
            // Form1
            // 
            this.ClientSize = new System.Drawing.Size(680, 296);
            this.Controls.Add(this.Decrypt_btn);
            this.Controls.Add(this.toolStripStatusLabel1);
            this.Controls.Add(this.Encrypt_btn);
            this.Controls.Add(this.CanSave_lbl);
            this.Controls.Add(this.ImageWidth_lbl);
            this.Controls.Add(this.ImageHeight_lbl);
            this.Controls.Add(this.ImageSize_lbl);
            this.Controls.Add(this.DeSaveFile_tbx);
            this.Controls.Add(this.DeLoadImage_tbx);
            this.Controls.Add(this.EnFile_tbx);
            this.Controls.Add(this.EnImage_tbx);
            this.Controls.Add(this.DeSaveFileBrowse_btn);
            this.Controls.Add(this.DeLoadImageBrowse_btn);
            this.Controls.Add(this.EnFileBrowse_btn);
            this.Controls.Add(this.EnImageBrowse_btn);
            this.Name = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button EnImageBrowse_btn;
        private System.Windows.Forms.Button EnFileBrowse_btn;
        private System.Windows.Forms.Button DeLoadImageBrowse_btn;
        private System.Windows.Forms.Button DeSaveFileBrowse_btn;
        private System.Windows.Forms.TextBox EnImage_tbx;
        private System.Windows.Forms.TextBox EnFile_tbx;
        private System.Windows.Forms.TextBox DeLoadImage_tbx;
        private System.Windows.Forms.TextBox DeSaveFile_tbx;
        private System.Windows.Forms.Label ImageSize_lbl;
        private System.Windows.Forms.Label ImageHeight_lbl;
        private System.Windows.Forms.Label ImageWidth_lbl;
        private System.Windows.Forms.Label CanSave_lbl;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.DirectoryServices.DirectoryEntry directoryEntry1;
        private System.Windows.Forms.OpenFileDialog openFileDialog2;
        private System.Windows.Forms.SaveFileDialog saveFileDialog1;
        private System.Windows.Forms.Button Encrypt_btn;
        private System.Windows.Forms.Label toolStripStatusLabel1;
        private System.Windows.Forms.Button Decrypt_btn;
        private System.Windows.Forms.OpenFileDialog openFileDialog3;
        private System.Windows.Forms.FolderBrowserDialog folderBrowserDialog1;

    }
}

