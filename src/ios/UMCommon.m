#import "UMCommon.h"

@implementation UMCommon
- (void)pluginInitialize
{
    
    [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(finishLaunching:) name:UIApplicationDidFinishLaunchingNotification object:nil];
    
}

- (void)finishLaunching:(NSNotification *)notification
{
    // Put here the code that should be on the AppDelegate.m
    // 获取IOS的Appkey
    NSString *appKey = [[self.commandDelegate settings] objectForKey:@"um_ios_key"];
    NSString *channel = [[self.commandDelegate settings] objectForKey:@"um_ios_channel"];
    NSLog(@"你的appKey为%@", appKey);
    
    /* 设置友盟appkey */
    [UMConfigure initWithAppkey:appKey channel:channel];
}

@end
