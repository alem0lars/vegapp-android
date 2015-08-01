/******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one                 *
 * or more contributor license agreements.  See the NOTICE file               *
 * distributed with this work for additional information                      *
 * regarding copyright ownership.  The ASF licenses this file                 *
 * to you under the Apache License, Version 2.0 (the                          *
 * "License"); you may not use this file except in compliance                 *
 * with the License.  You may obtain a copy of the License at                 *
 * http://www.apache.org/licenses/LICENSE-2.0                                 *
 * Unless required by applicable law or agreed to in writing,                 *
 * software distributed under the License is distributed on an                *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY                     *
 * KIND, either express or implied.  See the License for the                  *
 * specific language governing permissions and limitations                    *
 * under the License.                                                         *
 ******************************************************************************/

package rocks.molarialessandro.vegapp.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import rocks.molarialessandro.vegapp.app.models.GettingStartedItem;
import rocks.molarialessandro.vegapp.app.models.GettingStartedItems;

import java.math.BigInteger;

public class SplashScreen extends FragmentActivity
{
  private ViewPager pager;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splashscreen);

    // Instantiate the pager and its adapter.
    pager = (ViewPager) findViewById(R.id.splashscreen_pager);
    pager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager(),
                                               GettingStartedItems.createAll()));
  }

  @Override
  public void onBackPressed()
  {
    if (pager.getCurrentItem() == 0) {
      // If the user is currently looking at the first step, allow the system
      // to handle the Back button. This calls finish() on this activity and
      // pops the back stack.
      super.onBackPressed();
    } else {
      // Otherwise, select the previous page.
      pager.setCurrentItem(pager.getCurrentItem() - 1);
    }
  }

  /**
   * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
   * sequence.
   */
  private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter
  {
    private GettingStartedItems items;

    public ScreenSlidePagerAdapter(FragmentManager fm,
                                   GettingStartedItems items)
    {
      super(fm);
      this.items = items;
    }

    @Override
    public Fragment getItem(int position)
    {
      return SplashScreenPageFragment.newInstance(this.items.itemAt
          (BigInteger.valueOf(position)));
    }

    @Override
    public int getCount()
    {
      return this.items.amount().intValue();
    }
  }
}
