/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher3;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Settings activity for Launcher. Currently implements the following setting: Allow rotation
 */
public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new LauncherSettingsFragment())
                .commit();
    }

    /**
     * This fragment shows the launcher preferences.
     */
    public static class LauncherSettingsFragment extends PreferenceFragment
            implements OnPreferenceChangeListener {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.launcher_preferences);

            SwitchPreference pref = (SwitchPreference) findPreference(
                    Utilities.ALLOW_ROTATION_PREFERENCE_KEY);
            pref.setPersistent(false);

            Bundle extras = new Bundle();
            extras.putBoolean(LauncherSettings.Settings.EXTRA_DEFAULT_VALUE, false);
            Bundle value = getActivity().getContentResolver().call(
                    LauncherSettings.Settings.CONTENT_URI,
                    LauncherSettings.Settings.METHOD_GET_BOOLEAN,
                    Utilities.ALLOW_ROTATION_PREFERENCE_KEY, extras);
            pref.setChecked(value.getBoolean(LauncherSettings.Settings.EXTRA_VALUE));

            pref.setOnPreferenceChangeListener(this);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            Bundle extras = new Bundle();
            extras.putBoolean(LauncherSettings.Settings.EXTRA_VALUE, (Boolean) newValue);
            getActivity().getContentResolver().call(
                    LauncherSettings.Settings.CONTENT_URI,
                    LauncherSettings.Settings.METHOD_SET_BOOLEAN,
                    preference.getKey(), extras);
            return true;
        }
    }

    public static class AppsFragement extends Fragment {

        private RecyclerView mRv;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View inflate = View.inflate(inflater.getContext(), R.layout.fragment_apps_classifer, null);
            mRv = inflate.findViewById(R.id.rv);
            return inflate;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            initView();
        }

        private void initView() {

        }


    }


}
