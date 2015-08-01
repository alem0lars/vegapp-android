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

/**
 * Represent a getting started item, i.e. an atomic piece of information to help
 * normal users.
 */
public class GettingStartedItem implements Parcelable
{
  private final String title;
  private final String description;

  protected GettingStartedItem(final String title, final String description) {
    this.title = title;
    this.description = description;
  }

  /**
   * Create a new {link:GettingStartedItem}.
   *
   * @param title The title used for creating the new instance.
   * @param description The description used for creating the new instance.
   * @return The created instance.
   */
  public static GettingStartedItem create(final String title,
                                   final String description) {
    return new GettingStartedItem(title, description);
  }

  /**
   * @return The current title.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * @return The current description.
   */
  public String getDescription() {
    return this.description;
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
    dest.writeString(this.getTitle());
    dest.writeString(this.getDescription());
  }

  private static class GettingStartedItemCreator implements Creator<GettingStartedItem>
  {
    @Override
    public GettingStartedItem createFromParcel(Parcel source)
    {
      return GettingStartedItem.create(source.readString(),
                                       source.readString());
    }

    @Override
    public GettingStartedItem[] newArray(int size)
    {
      return new GettingStartedItem[size];
    }
  }

  public static final GettingStartedItemCreator CREATOR = new
      GettingStartedItemCreator();

  // }}}
}
