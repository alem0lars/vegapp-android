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

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import rocks.molarialessandro.vegapp.app.models.GettingStartedItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SplashScreenPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SplashScreenPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplashScreenPageFragment extends Fragment
{
  // {{{ Arguments.

  private static final String ARG_GETTINGSTARTED_ITEM  = "gettingstarted_item";

  private GettingStartedItem gettingStartedItem;

  // }}}

  private OnFragmentInteractionListener listener;

  /**
   * Use this factory method to create a new instance of this fragment using the
   * provided parameters.
   *
   * @param gettingStartedItem The model for the new instance.
   * @return A new instance of fragment {link:SplashScreenPageFragment}.
   */
  // TODO: Rename and change types and number of parameters
  public static SplashScreenPageFragment newInstance(
      final GettingStartedItem gettingStartedItem)
  {
    SplashScreenPageFragment fragment = new SplashScreenPageFragment();
    Bundle                   args     = new Bundle();

    args.putParcelable(ARG_GETTINGSTARTED_ITEM, gettingStartedItem);
    fragment.setArguments(args);

    return fragment;
  }

  public SplashScreenPageFragment()
  {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      this.gettingStartedItem = getArguments().getParcelable(ARG_GETTINGSTARTED_ITEM);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState)
  {
    // Inflate the layout for this fragment
    return inflater
        .inflate(R.layout.fragment_splashscreenpage, container, false);
  }

  @Override
  public void onAttach(Activity activity)
  {
    super.onAttach(activity);
    try {
      listener = (OnFragmentInteractionListener) activity;
    } catch (ClassCastException e) {
      throw new ClassCastException(String.format(
          "%s must implement OnFragmentInteractionListener",
          activity.toString()));
    }
  }

  @Override
  public void onDetach()
  {
    super.onDetach();
    listener = null;
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p/>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener
  {
    // TODO: Update argument type and name
    public void onFragmentInteraction(Uri uri);
  }

}
