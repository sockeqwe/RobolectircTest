package com.example.lib;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

@RunWith(CustomRobolectricRunner.class)
@Config(emulateSdk = 21, reportSdk = 21)
public class MyFragmentTest {

  @Test public void testAppFragmentStart() {
    final TestFragment fragment = new TestFragment();

    ActivityController controller = Robolectric.buildActivity(FragmentActivity.class);
    FragmentActivity activity = (FragmentActivity) controller.create().start().resume().visible().get();

    FragmentManager manager = activity.getSupportFragmentManager();
    manager.beginTransaction()
        .add(fragment, "fragmentTag").commit();

    // My test examples - hamcrest matchers
    Assert.assertThat(fragment, CoreMatchers.not(CoreMatchers.nullValue()));
    Assert.assertThat(fragment.getView(), CoreMatchers.not(CoreMatchers.nullValue()));
    Assert.assertThat(fragment.getActivity(), CoreMatchers.not(CoreMatchers.nullValue()));
    Assert.assertThat(fragment.getActivity(), CoreMatchers.instanceOf(FragmentActivity.class));

    // Your tests
    View loadingView = fragment.getView().findViewById(R.id.loadingView);
    View contentView = fragment.getView().findViewById(R.id.contentView);
    View errorView = fragment.getView().findViewById(R.id.loadingView);

    Assert.assertNotSame(loadingView.getVisibility(), View.VISIBLE);
    Assert.assertNotSame(errorView.getVisibility(), View.VISIBLE);
    Assert.assertEquals(contentView.getVisibility(), View.VISIBLE);
  }
}