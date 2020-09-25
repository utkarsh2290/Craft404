package com.mstc.craft404.fragments.AboutUs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mstc.craft404.R;

public class aboutusChapter extends Fragment {

    private ImageButton buttonFacebookStc,buttonInstagramStc,buttonLinkedInStc;
    private ImageButton buttonFacebookSiam,buttonInstagramSiam,buttonLinkedInSiam;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chapter,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViewById(view);
        onClickListener();
        onClickListener2();
    }


    private void findViewById(View view)
    {
        buttonFacebookStc = view.findViewById(R.id.button_fb_stc);
        buttonInstagramStc = view.findViewById(R.id.button_instagram_stc);
        buttonLinkedInStc = view.findViewById(R.id.button_linkedin_stc);


        buttonFacebookSiam = view.findViewById(R.id.button_fb_siam);
        buttonInstagramSiam = view.findViewById(R.id.button_instagram_siam);
        buttonLinkedInSiam = view.findViewById(R.id.button_linkedin_siam);


    }


    private void onClickListener()
    {
        buttonInstagramStc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.instagram.com/mstcvit/")));
                startActivity(intent);
            }
        });

        buttonLinkedInStc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.linkedin.com/company/micvitvellore/")));
                startActivity(intent);
            }
        });

        buttonFacebookStc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.facebook.com/mstcvit/")));
                startActivity(intent);
            }
        });

    }
    private void onClickListener2()
    {
        buttonInstagramSiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.instagram.com/siamvit/")));
                startActivity(intent);
            }
        });

        buttonLinkedInSiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.linkedin.com/company/siam-vit/")));
                startActivity(intent);
            }
        });

        buttonFacebookSiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData((Uri.parse("https://www.facebook.com/SIAMVIT/")));
                startActivity(intent);
            }
        });

    }



}
