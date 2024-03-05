package Base;

public class Check1 {

    public static String checkt(String choice){
        String things ;
        switch (choice){
            case "用户身份认证": things = "应对登录的用户进行身份标识和鉴别，身份标识具有唯一性，身份鉴别信息具有复杂度要求并定期更换。";break;
            case "登录失败认证": things = "应具有登录失败处理功能，应配置并启用结束会话、限制非法登录次数和当登录连接超时自动退出等相关措施";break;
            case "用户权限分配": things = "系统用户需以最小化原则分配权限";break;
            case "默认用户检查": things = "应重命名或删除默认账户，修改默认账户的默认口令";break;
            case "共享用户检查": things = "应及时删除或停用多余的、过期的账户，避免共享账户的存在";break;
            case "安全审计检查": things = "应启用安全审计功能，审计覆盖到每个用户，对重要的用户行为和重要安全事件进行审计";break;
            case "日志备份检查": things = "应对审计记录进行保护，定期备份，避免受到未预期的删除、修改或覆盖等";break;
            case "最小安装检查": things = "应遵循最小安装的原则仅安装需要的组件和应用程序";break;
            case "高危端口检查": things = "应关闭不需要的系统服务、默认共享和高危端口（22、135、137、138、139、445、3389等）";break;
            case "杀毒软件检查": things = "服务器需安装的杀毒软件并确保病毒库为最新版本。";break;
            case "软件兼容版本": things = "在不影响系统的情况下升级软件至最高版本。";break;
            case "系统补丁更新": things = "服务器需定期升级操作系统补丁，确保系统为最新版本。";break;
            case "系统备份机制": things = "系统需具有备份与恢复机制，并定期备份。";break;
            case "恶意代码防范": things = "重要服务器主机应采取恶意代码防范措施。";break;
            case "移动介质接入": things = "移动存储介质在接入本部门计算机和信息系统时，是否具备接入防护机制，如查杀病毒、木马等。";break;
            case "远控软件检测": things = "禁止在未经报备的情况下使用“向日葵”等远程控制类软件。";break;
            default:
                things = "";
        }
        return things;
    }


}
