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
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.textViewEconomy) TextView mEconomy;
    @Bind(R.id.textViewInWork) TextView mInWork;
    @Bind(R.id.textViewCreatedDate) TextView mCreatedDate;
    @Bind(R.id.textViewRegisteredDate) TextView mRegisteredDate;
    @Bind(R.id.textViewDecisionDate) TextView mDecisionDate;
    @Bind(R.id.textViewResponsibleName) TextView mResponsibleName;
    @Bind(R.id.textViewDescription) TextView mDescription;
    @Bind(R.id.textViewCreated) TextView mCreated;
    @Bind(R.id.textViewRegistered) TextView mRegistered;
    @Bind(R.id.textViewDecision) TextView mDecision;
    @Bind(R.id.textViewResponsible) TextView mResponsible;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private List<Uri> mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mImageUri = new ArrayList<>();

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setValues();

        addListeners();
    }

    private void setValues(){

        for (String  i: getResources().getStringArray(R.array.link_photo)){
            mImageUri.add(Uri.parse(i));
        }

        mEconomy.setText(R.string.economy_name);
        mInWork.setText(R.string.in_work_name);
        mCreatedDate.setText(R.string.created_name);
        mRegisteredDate.setText(R.string.registered_name);
        mDecisionDate.setText(R.string.decision_date_name);
        mResponsibleName.setText(R.string.responsible_name);
        mDescription.setText(R.string.description_name);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        AdapterForRecyclerView adapter = new AdapterForRecyclerView(mImageUri, this);
        mRecyclerView.setAdapter(adapter);
    }

    private void addListeners(){

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, v.getClass().getSimpleName(),Toast.LENGTH_SHORT)
                        .show();
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
}

