package com.example.autoflipfinal;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.os.Environment;
import java.util.HashMap;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.cos.COSDocument;
import java.io.FileInputStream;
import java.util.Map;
import java.text.SimpleDateFormat;
import org.apache.pdfbox.util.PDFTextStripper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import com.ipaulpro.afilechooser.utils.FileUtils;
import java.io.File;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.AlertDialog;
import android.util.Log;
import java.io.FilenameFilter;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends Activity {

	protected int currentCard = 0;
	
	protected Button importButton, samplePresentation;
	
	protected File file;
	
	protected Presentation presentation = new Presentation();

	protected static final int REQUEST_CHOOSER = 1234;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		importButton = (Button) findViewById(R.id.importButton);
		importButton.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			    Intent getContentIntent = FileUtils.createGetContentIntent();
			    Intent intent = Intent.createChooser(getContentIntent, "Select a file");
			    startActivityForResult(intent, REQUEST_CHOOSER);
			    
			}
		});
		
		samplePresentation = (Button) findViewById(R.id.samplePresentation);
		samplePresentation.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(MainActivity.this, PresentationActivity.class);
				startActivity(myIntent);
				
			}
		});
		
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    switch (requestCode) {
	        case REQUEST_CHOOSER:   
	            if (resultCode == RESULT_OK) {  
	                Uri uri = data.getData();
               		Log.e("",  uri.toString());

	                file = FileUtils.getFile(uri);
	                	                
	                Log.e("", "it got the file");
	               	if (!file.canRead()){
	               		Log.e("", "WE CAN'T!");
	               	}
	               	String text = pdfToText(file); //processPDF(file, new HashMap<String, String>());
	               	
	               	Log.e("", text);
	            }
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

  //In an Activity
    private String[] mFileList;
    private File mPath = new File(Environment.getExternalStorageDirectory().toURI());
    private String mChosenFile;
    private static final String FTYPE = ".pdf";    
    private static final int DIALOG_LOAD_FILE = 1000;


 // Extract text from PDF Document
 	public static String pdfToText(File file) {
 		PDFParser parser;
 		String parsedText = null;;
 		PDFTextStripper pdfStripper = null;
 		PDDocument pdDoc = null;
 		COSDocument cosDoc = null;

 		try {
 			parser = new PDFParser(new FileInputStream(file));
 		} catch (IOException e) {
 			System.err.println("Unable to open PDF Parser. " + e.getMessage());
 			return null;
 		}
 		try {
 			parser.parse();
 			cosDoc = parser.getDocument();
 			pdfStripper = new PDFTextStripper();
 			pdDoc = new PDDocument(cosDoc);
 			pdfStripper.setStartPage(1);
 			pdfStripper.setEndPage(5);
 			parsedText = pdfStripper.getText(pdDoc);
 		} catch (Exception e) {
 			System.err
 					.println("An exception occured in parsing the PDF Document."
 							+ e.getMessage());
 		} finally {
 			try {
 				if (cosDoc != null)
 					cosDoc.close();
 				if (pdDoc != null)
 					pdDoc.close();
 			} catch (Exception e) {
 				e.printStackTrace();
 			}
 		}
 		return parsedText;
 	}

    
    private String processPDF(File file, /*String outputDateMask,*/ Map<String, String> metadata) throws Throwable {
        PDFTextStripper pdfS = new PDFTextStripper();
        PDDocument pdoc = new PDDocument();
        pdoc = PDDocument.load(file);
        PDDocumentInformation info = pdoc.getDocumentInformation();
        if (info.getTitle() != null) {
            metadata.put("title",info.getTitle());
        }
        if (info.getAuthor() != null) {
            metadata.put("author",info.getAuthor());
        }
        if (info.getSubject() != null) {
            metadata.put("subject",info.getSubject());
        }
        if (info.getKeywords() != null) {
            metadata.put("keywords",info.getKeywords());
        }
        if (info.getCreator() != null) {
            metadata.put("creator",info.getCreator());
        }
        if (info.getProducer() != null) {
            metadata.put("producer",info.getProducer());
        }
        //SimpleDateFormat sdf = new SimpleDateFormat(outputDateMask);
        if (info.getModificationDate() != null) {
    //        metadata.put("published",sdf.format(info.getModificationDate().getTime()));
        } else if (info.getCreationDate() != null) {
    //        metadata.put("published",sdf.format(info.getCreationDate().getTime()));
        }
        
        return pdfS.getText(pdoc);
    }
}
