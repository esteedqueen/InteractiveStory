package com.amber.esther.interactivestory.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amber.esther.interactivestory.R;
import com.amber.esther.interactivestory.model.Page;
import com.amber.esther.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();

        mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null) {
            mName = "Friend";
        }

        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage();
    }

    private void  loadPage() {
        Page page = mStory.getPage(0);
        Context context = this;

//        Drawable drawable = getResources().getDrawable(page.getImageId(), null);
        Drawable drawable = ContextCompat.getDrawable(context, page.getImageId());

        mImageView.setImageDrawable(drawable);

        String pageText = page.getText();
        // Add the name if placeholder included, won't add if no placeholder

        pageText = String.format(pageText, mName);

        mTextView.setText(pageText);
        mChoice1.setText(page.getChoice1().getText());
        mChoice2.setText(page.getChoice2().getText());

    }



}
