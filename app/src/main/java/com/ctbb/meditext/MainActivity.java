package com.ctbb.meditext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ctbb.meditext.mention.Tag;
import com.ctbb.meditext.mention.User;
import com.ctbb.meditext.mention.edit.MentionEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    MentionEditText etContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etContent = findViewById(R.id.et_content);
    }

    public void btnTopic1(View view){
        etContent.insert(new Tag("话题1"));
    }

    public void btnUser1(View view){
        etContent.insert(new User("123","风再起时"));
    }

    public void submit(View view){
        String content = etContent.getFormatCharSequence().toString();
        String wordentry = "";
        String mentionIds = "";
        if (!TextUtils.isEmpty(content)) {
            //输入内容不为空
            Pattern pattern = Pattern.compile("#([^\\\\#|.]+)#", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(content);
            StringBuilder builder = new StringBuilder();
            while (matcher.find()) {
                //将匹配到的内容进行统计处理
                if (matcher.group().length() <= 52) {
                    builder.append(matcher.group() + "|");
                }
            }
            if (builder.toString().length() > 2) {
                wordentry = builder.toString().substring(0, builder.toString().length() - 1);
                Log.i("ctbb", "wordentry=" + wordentry);
            }

            StringBuilder mentionBuilder = new StringBuilder();
            String regEx_img = "<user[^>]*>([\\s\\S]*?)<\\/user>";
            pattern = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(content);
            while (matcher.find()) {
                //将匹配到的内容进行统计处理
                String usertag = matcher.group();
                Matcher m = Pattern.compile("id\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(usertag);
                while (m.find()) {
                    mentionBuilder.append(m.group(1));
                    mentionBuilder.append(",");
                }
            }
            if (mentionBuilder.toString().length() > 2) {
                mentionIds = mentionBuilder.toString().substring(0, mentionBuilder.toString().length() - 1);
                Log.i("ctbb", "mentionIds=" + mentionIds);
            }
            Log.i("ctbb","content="+content);
        }else {
            Toast.makeText(this,"请输入内容",Toast.LENGTH_SHORT).show();
        }
    }
}