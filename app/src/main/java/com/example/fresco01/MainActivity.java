package com.example.fresco01;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_image)
    SimpleDraweeView myImage;
    @BindView(R.id.btn_yuanjiao)
    Button btnYuanjiao;
    @BindView(R.id.btn_yuanxing)
    Button btnYuanxing;
    @BindView(R.id.btn_bili)
    Button btnBili;
    @BindView(R.id.btn_jianjinshi)
    Button btnJianjinshi;
    @BindView(R.id.btn_cipanhuanxun)
    Button btnCipanhuanxun;
    @BindView(R.id.btn_jiazaidonghua)
    Button btnJiazaidonghua;
    @BindView(R.id.btn_jiazaijianting)
    Button btnJiazaijianting;
    @BindView(R.id.btn_peizhi)
    Button btnPeizhi;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 初始化控件
         */
        unbinder = ButterKnife.bind(this);
        Uri uri = Uri.parse("https://p0.ssl.qhimgs1.com/bdr/200_200_/t014b3fc0eef5e6940c.jpg");
//        draweeView = findViewById(R.id.my_image);
        myImage.setImageURI(uri);

    }

    @OnClick({R.id.btn_yuanjiao, R.id.btn_yuanxing, R.id.btn_bili, R.id.btn_jianjinshi, R.id.btn_cipanhuanxun, R.id.btn_jiazaidonghua, R.id.btn_jiazaijianting, R.id.btn_peizhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_yuanjiao:

                RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                roundingParams.setCornersRadius(50f);
                myImage.getHierarchy().setRoundingParams(roundingParams);

                break;
            case R.id.btn_yuanxing:

                RoundingParams rounding = RoundingParams.fromCornersRadius(5f);
                rounding.setRoundAsCircle(true);
                myImage.getHierarchy().setRoundingParams(rounding);

                break;
            case R.id.btn_bili:
                myImage.setAspectRatio(1.2f);
                break;
            case R.id.btn_jianjinshi:
                Uri uri = Uri.parse("https://p0.ssl.qhimgs1.com/bdr/200_200_/t014b3fc0eef5e6940c.jpg");
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setProgressiveRenderingEnabled(true)
                        .build();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(myImage.getController())
                        .build();
                myImage.setController(controller);
                break;
            case R.id.btn_cipanhuanxun:

                break;
            case R.id.btn_jiazaidonghua:

                Uri uri1 = Uri.parse("http://ww2.sinaimg.cn/large/85cccab3gw1etdge31p06g20ia0dqkjl.jpg");
                DraweeController controlle = Fresco.newDraweeControllerBuilder()
                        .setUri(uri1)
                        .setAutoPlayAnimations(true)
                        .build();
                myImage.setController(controlle);
                break;
            case R.id.btn_jiazaijianting:
                break;
            case R.id.btn_peizhi:
                break;
        }
    }
}
