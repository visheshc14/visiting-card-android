package com.community.jboss.visitingcard.IntroScreens;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TypefaceSpan;

import com.community.jboss.visitingcard.R;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

public class WelcomeActivity extends IntroActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setButtonBackVisible(false);
        setButtonNextVisible(false);
        setButtonCtaVisible(true);
        setButtonCtaTintMode(BUTTON_CTA_TINT_MODE_BACKGROUND);
        TypefaceSpan labelSpan = new TypefaceSpan(
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? "sans-serif-medium" : "sans serif");
        SpannableString label = SpannableString
                .valueOf(getString(R.string.get_started));
        label.setSpan(labelSpan, 0, label.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        setButtonCtaLabel(label);

        setPageScrollDuration(500);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setPageScrollInterpolator(android.R.interpolator.fast_out_slow_in);
        }

        addSlide(new SimpleSlide.Builder()
                .title(R.string.welcome_intro1)
                .description(R.string.description_intro1)
                .image(R.drawable.ic_launcher_foreground)
                .background(R.color.color_1)
                .backgroundDark(R.color.color)
                .layout(R.layout.slide_welcome)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.welcome_intro2)
                .description(R.string.description_intro2)
                .image(R.drawable.art_welcome_intro2)
                .background(R.color.color_1)
                .backgroundDark(R.color.color)
                .layout(R.layout.slide_welcome)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.welcome_intro3)
                .description(R.string.description_intro3)
                .image(R.drawable.art_welcome_intro3)
                .background(R.color.color_3)
                .backgroundDark(R.color.color)
                .layout(R.layout.slide_welcome)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title(R.string.welcome_intro4)
                .description(R.string.description_intro4)
                .image(R.drawable.art_welcome_intro4)
                .background(R.color.color_4)
                .backgroundDark(R.color.color)
                .layout(R.layout.slide_welcome)
                .build());

        autoplay(2500, INFINITE);
    }
}
