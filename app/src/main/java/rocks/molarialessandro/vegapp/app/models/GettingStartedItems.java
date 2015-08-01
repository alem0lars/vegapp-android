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

package rocks.molarialessandro.vegapp.app.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GettingStartedItems implements Iterable<GettingStartedItem>,
                                            Parcelable
{
  private final List<GettingStartedItem> items;

  private GettingStartedItems(List<GettingStartedItem> items)
  {
    this.items = new ArrayList<>(items);
  }

  public static GettingStartedItems createAll()
  {
    return new GettingStartedItems(Arrays.asList(
        GettingStartedItem.create("Pippo", "Io sono pippo"),
        GettingStartedItem.create("Pluto", "Io sono pluto")));
  }

  @Override
  public Iterator<GettingStartedItem> iterator()
  {
    return this.items.iterator();
  }

  public BigInteger amount() {
    return BigInteger.valueOf(this.items.size());
  }

  public GettingStartedItem itemAt(final BigInteger index) {
    return this.items.get(index.intValue());
  }

  // {{{ Implement {link:Parcelable}

  @Override
  public int describeContents()
  {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags)
  {
    dest.writeTypedList(this.items);
  }

  private static class GettingStartedItemsCreator implements Creator<GettingStartedItems>
  {
    public GettingStartedItems createFromParcel(Parcel in)
    {
      List<GettingStartedItem> items = new ArrayList<>();
      in.readTypedList(items, GettingStartedItem.CREATOR);
      return new GettingStartedItems(items);
    }

    public GettingStartedItems[] newArray(int size)
    {
      return new GettingStartedItems[size];
    }
  }

  public static final GettingStartedItemsCreator CREATOR = new GettingStartedItemsCreator();

  // }}}
}
