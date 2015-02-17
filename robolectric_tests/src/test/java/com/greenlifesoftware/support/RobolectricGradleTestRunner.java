package com.greenlifesoftware.support;

import org.junit.runners.model.InitializationError;
import org.robolectric.AndroidManifest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.res.Fs;

import java.io.File;
import java.io.IOException;

public class RobolectricGradleTestRunner extends RobolectricTestRunner
{
    private static final String EMPTY_STRING = "";
    private static final String PATH_SEPARATOR = "/";
    private static final String CURRENT_DIRECTORY = ".";

    // Project modules
    private static final String APP_MODULE = "app";
    private static final String ROBOLECTRIC_MODULE = "robolectric_tests";

    // Max SDK version
    private static final int MAX_SDK_SUPPORTED_BY_ROBOLECTRIC = 18;

    // Project locations
    private static final String MANIFEST_PATH = "src/main/AndroidManifest.xml";
    private static final String RES_PATH = "build/intermediates/res/debug/";

    // Path configuration
    private static final String PROJECT_DIR = getProjectDirectory();
    private static final String FINAL_MANIFEST_PATH = PROJECT_DIR + MANIFEST_PATH;
    private static final String FINAL_RES_PATH = PROJECT_DIR + RES_PATH;

    public RobolectricGradleTestRunner( final Class<?> testClass ) throws InitializationError
    {
        super( testClass );
    }

    @Override
    public AndroidManifest getAppManifest( Config config )
    {
        return new AndroidManifest( Fs.fileFromPath( FINAL_MANIFEST_PATH ), Fs.fileFromPath(
                FINAL_RES_PATH ) )
        {
            @Override
            public int getTargetSdkVersion()
            {
                return MAX_SDK_SUPPORTED_BY_ROBOLECTRIC;
            }
        };
    }

    /**
     * Robolectric has difficulty recognizing the manifest file from relative paths.
     *
     * @return The working directory from which tests are run.
     */
    private static String getProjectDirectory()
    {
        String path = EMPTY_STRING;
        try
        {
            File file = new File( CURRENT_DIRECTORY );
            path = file.getCanonicalPath();

            // Test Module
            path = path.replace( ROBOLECTRIC_MODULE, EMPTY_STRING );

            // Application Module
            path = path.replace( APP_MODULE, EMPTY_STRING );
            path = path + PATH_SEPARATOR + APP_MODULE + PATH_SEPARATOR;
        }
        catch (IOException ignored)
        {
        }

        return path;
    }
}