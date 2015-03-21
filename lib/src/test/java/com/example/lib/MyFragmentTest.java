package com.example.lib;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.robolectric.util.FragmentTestUtil;

public class MyFragmentTest {

  @Test public void testAppFragmentStart() {
    final TestFragment fragment = new TestFragment();

    FragmentTestUtil.startFragment(fragment, FragmentActivity.class); // startVisibleFragment

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