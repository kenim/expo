package expo.adapters.react;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;

import expo.core.ModuleRegistry;

/**
 * {@link ModuleRegistryReadyNotifier} is exported as a native module
 * to React Native and when {@link com.facebook.react.ReactInstanceManager}
 * notifies {@link com.facebook.react.bridge.NativeModule} of being ready
 * ({@link NativeModule#initialize()}) it delegates the call to {@link ModuleRegistry}.
 */
/* package */ class ModuleRegistryReadyNotifier extends BaseJavaModule {
  private ReactApplicationContext mContext;
  private ModuleRegistry mModuleRegistry;
  private ModuleRegistryWrapper mModuleRegistryWrapper;

  /* package */ ModuleRegistryReadyNotifier(ReactApplicationContext context, ModuleRegistry moduleRegistry, ModuleRegistryWrapper wrapper) {
    mContext = context;
    mModuleRegistry = moduleRegistry;
    mModuleRegistryWrapper = wrapper;
  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public void initialize() {
    mModuleRegistry.initialize();
  }

  @Override
  public void onCatalystInstanceDestroy() {
    super.onCatalystInstanceDestroy();
    mModuleRegistryWrapper.onCatalystInstanceDestroy(mContext);
  }
}