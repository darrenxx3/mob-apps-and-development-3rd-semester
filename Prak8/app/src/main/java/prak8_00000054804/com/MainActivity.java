package prak8_00000054804.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    private static final int NUMBER_PAGES=4;
    private ViewPager2 viewPager2;
    private FragmentStateAdapter pagerAdapter;

    //untuk memanggil viewpager
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2=findViewById(R.id.pager);
        pagerAdapter=new ScreenSlidePageAdapter(this);
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setPageTransformer(new ZoomOutPageTransformer());
    }

    /*
    ScreenSlidePage merupakan slider apabila user swipe maka akan memunculkan
    page baru dengan transisi slide*/
    private class ScreenSlidePageAdapter extends FragmentStateAdapter {
        public ScreenSlidePageAdapter(MainActivity mainActivity) {
            super(mainActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();
                case 2:
                    return new FragmentThree();
                default:
                    return null;
            }
        }

        @Override
        public int getItemCount() {

            return NUMBER_PAGES;
        }
    }

    /*code dibawah ini merupakan cara untuk peralihan transisinya berapa detik animasinya*/
    private class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MINIMAL_SCALE=0.85f;
        private static final float MINIMAL_ALPHA=0.5f;
        @Override
        public void transformPage(@NonNull View page, float position) {
            int pagewidth=page.getWidth();
            int pageheight=page.getHeight();
            if (position<-1){
                page.setAlpha(0f);
            }
            else if(position <=1){
                float scaleFactor=Math.max(MINIMAL_SCALE, 1-Math.abs(position));
                float verticalMargin=pageheight*(1-scaleFactor) /2;
                float horizontalMargin=pagewidth*(1-scaleFactor) /2;

                if (position<0){
                    page.setTranslationX(horizontalMargin-verticalMargin/2);
                }else{
                    page.setTranslationX(-horizontalMargin+verticalMargin/2);
                }
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
                page.setAlpha(MINIMAL_ALPHA+(scaleFactor-MINIMAL_SCALE)/ (1-MINIMAL_SCALE)*(1-MINIMAL_SCALE));
            }
            else{
                page.setAlpha(0f);
            }
        }

    }
}