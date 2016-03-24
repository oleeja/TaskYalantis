package com.kitsyambochka.yalantistask1;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemRecyclerViewListener {
    private Toolbar mToolbar;
    private TextView mEconomy, mInWork, mCreatedDate, mRegisteredDate, mDecisionDate,
            mResponsibleName, mDescription;
    private TextView mCreated, mRegistered, mDecision, mResponsible;
    private RecyclerView mRecyclerView;

    private ArrayList<Uri> mImageUri;

    private String mControlsName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationIcon(R.drawable.ic_arrow_white);
        mEconomy = (TextView)findViewById(R.id.textViewEconomy);
        mInWork = (TextView)findViewById(R.id.textViewInWork);
        mCreatedDate = (TextView)findViewById(R.id.textViewCreatedDate);
        mRegisteredDate = (TextView)findViewById(R.id.textViewRegisteredDate);
        mDecisionDate = (TextView)findViewById(R.id.textViewDecisionDate);
        mResponsibleName = (TextView)findViewById(R.id.textViewResponsibleName);
        mDescription = (TextView)findViewById(R.id.textViewDescription);
        mCreated = (TextView)findViewById(R.id.textViewCreated);
        mRegistered = (TextView)findViewById(R.id.textViewRegistered);
        mDecision = (TextView)findViewById(R.id.textViewDecision);
        mResponsible = (TextView)findViewById(R.id.textViewResponsible);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);


        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mImageUri = new ArrayList<>();

        setValues();

        addListeners();
    }

    private void setValues(){
        mImageUri.add(Uri.parse("http://i.imgur.com/8SihmuM.jpg"));
        mImageUri.add(Uri.parse("http://i.imgur.com/W1SkL5G.jpg"));
        mImageUri.add(Uri.parse("http://i.imgur.com/Zb7vTJm.jpg"));

        mEconomy.setText(R.string.economy_name);
        mInWork.setText(R.string.in_work_name);
        mCreatedDate.setText(R.string.created_name);
        mRegisteredDate.setText(R.string.registered_name);
        mDecisionDate.setText(R.string.decision_date_name);
        mResponsibleName.setText(R.string.responsible_name);
        mDescription.setText(R.string.description_name);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        MyAdapter adapter = new MyAdapter(mImageUri, this, this);
        mRecyclerView.setAdapter(adapter);
    }

    private void addListeners(){


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.textViewEconomy:
                    case R.id.textViewInWork:
                    case R.id.textViewCreated:
                    case R.id.textViewCreatedDate:
                    case R.id.textViewRegistered:
                    case R.id.textViewRegisteredDate:
                    case R.id.textViewDecision:
                    case R.id.textViewDecisionDate:
                    case R.id.textViewResponsible:
                    case R.id.textViewResponsibleName:
                    case R.id.textViewDescription:
                        mControlsName = "TextView";
                        break;
                    case R.id.toolbar:
                        mControlsName = "Toolbar";
                        break;
                }
                Toast.makeText(MainActivity.this, mControlsName,Toast.LENGTH_SHORT).show();
            }
        };

        mEconomy.setOnClickListener(onClickListener);
        mInWork.setOnClickListener(onClickListener);
        mCreatedDate.setOnClickListener(onClickListener);
        mRegisteredDate.setOnClickListener(onClickListener);
        mDecisionDate.setOnClickListener(onClickListener);
        mResponsibleName.setOnClickListener(onClickListener);
        mDescription.setOnClickListener(onClickListener);
        mCreated.setOnClickListener(onClickListener);
        mRegistered.setOnClickListener(onClickListener);
        mDecision.setOnClickListener(onClickListener);
        mResponsible.setOnClickListener(onClickListener);

        mToolbar.setOnClickListener(onClickListener);

        mRecyclerView.setOnClickListener(onClickListener);
    }

    @Override
    public void onImageViewClick() {
        mControlsName = "ImageView";
        Toast.makeText(MainActivity.this, mControlsName, Toast.LENGTH_SHORT).show();
    }
}
