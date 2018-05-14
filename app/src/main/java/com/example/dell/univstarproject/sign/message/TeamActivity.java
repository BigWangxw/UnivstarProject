package com.example.dell.univstarproject.sign.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.dell.univstarproject.R;
import com.example.dell.univstarproject.base.BaseApp;
import com.example.dell.univstarproject.model.http.ShapeUtils;
import com.example.dell.univstarproject.sign.entry.Team;
import com.example.dell.univstarproject.sign.prisenter.ITeamprisenter;
import com.example.dell.univstarproject.sign.prisenter.Teamprisenter;
import com.example.dell.univstarproject.sign.signview.TeamView;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity implements TeamView, View.OnClickListener {

    private ImageView team_back;
    private RecyclerView team_recy;
    private ITeamprisenter teamprisenter;
    private int id;
    private List<Team.DataBean.ListBean> listBeans = new ArrayList<>();
    private String content;
    private TeamAdapter teamAdapter;
    private String content1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        BaseApp.content = this;
        initView();
    }

    @Override
    protected void onStop() {
        super.onStop();
        BaseApp.content = null;
    }

    private void initView() {
        int id = ShapeUtils.getIntance().getId();
        teamprisenter = new Teamprisenter(this);
        teamprisenter.loadTeam(id);
        team_back = findViewById(R.id.team_back);
        team_recy = findViewById(R.id.team_recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        team_recy.setLayoutManager(linearLayoutManager);
        team_back.setOnClickListener(this);
        teamAdapter = new TeamAdapter(listBeans, this);
        team_recy.setAdapter(teamAdapter);
    }

    @Override
    public void showTeam(List<Team.DataBean.ListBean> team) {
        content1 = team.get(0).getContent();
        listBeans.addAll(team);
        teamAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.team_back:
                Intent intent = getIntent();
                intent.putExtra("aaa",content1);
                setResult(1234,intent);
                finish();
                break;
        }
    }
}
