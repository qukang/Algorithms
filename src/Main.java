import java.util.*;


/*
350410;嘉兴中心;浙江省;西安中心;陕西省;9.6m;
350424;西安中心;陕西省;嘉兴中心;浙江省;9.6m;
350428;嘉兴中心;浙江省;长沙中心;湖南省;17.5m;
350432;长沙中心;湖南省;武汉中心;湖北省;17.5m;
350448;武汉中心;湖北省;嘉兴中心;浙江省;17.5m;
350476;嘉兴中心;浙江省;潍坊中心;山东省;9.6m;
350479;潍坊中心;山东省;嘉兴中心;浙江省;17.5m;
350481;嘉兴中心;浙江省;成都中心;四川省;9.6m;
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new LinkedList<>();
        int i = 0;
        while (i<=7) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
            i++;
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new LinkedList<String>();
        final String type1 = "9.6m";
        final String type2 = "17.5m";
        StringBuilder sb1 = new StringBuilder("rule1:");
        StringBuilder sb2 = new StringBuilder("rule2:");
        StringBuilder sb3 = new StringBuilder("rule3:");
        boolean exist1 = false;
        boolean exist2 = false;
        boolean exist3 = false;

        for(int i = 0;i<lineList.size();i++){
            UnilateralLine A = lineList.get(i);

            for(int j = 0;j<lineList.size();j++){
                if(i==j) continue;
                UnilateralLine B = lineList.get(j);

                if(A.getECen().compareTo(B.getSCen())==0){//A->B
                    if(A.getSCen().compareTo(B.getECen())==0){//B->A
                        if(A.getTType().compareTo(B.getTType())==0){
                            sb1.append(A.getId()).append("+").append(B.getId());
                            lineList.remove(A);
                            lineList.remove(B);
                            exist1 = true;
                            break;
                        }else{
                            if(A.getTType().compareTo(type1)==0){
                                for(int k = 0;k<lineList.size();k++){
                                    if(k==i||k==j) continue;
                                    UnilateralLine C = lineList.get(k);
                                    if(C.getECen().compareTo(B.getSCen())==0&&C.getTType().compareTo(type1)==0){
                                        sb1.append(A.getId()).append("+").append(C.getId()).append("+").append(B.getId());
                                        lineList.remove(A);
                                        lineList.remove(B);
                                        lineList.remove(C);
                                        exist1 = true;
                                        break;
                                    }
                                }
                            }else{
                                for(int k = 0;k<lineList.size();k++){
                                    if(k==i||k==j) continue;
                                    UnilateralLine C = lineList.get(k);
                                    if(C.getSCen().compareTo(A.getECen())==0&&C.getTType().compareTo(type1)==0){
                                        sb1.append(A.getId()).append("+").append(B.getId()).append("+").append(C.getId());
                                        lineList.remove(A);
                                        lineList.remove(B);
                                        lineList.remove(C);
                                        exist1 = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }else if(A.getTType().compareTo(B.getTType())==0){//B->C
                        for(int k = 0;k<lineList.size();k++){
                            if(k==i||k==j) continue;
                            UnilateralLine C = lineList.get(k);
                            if(B.getECen().compareTo(C.getSCen())==0&&C.getECen().compareTo(A.getSCen())==0&&C.getTType().compareTo(A.getTType())==0){//C->A
                                sb2.append(A.getId()).append("+").append(B.getId()).append("+").append(C.getId());
                                lineList.remove(A);
                                lineList.remove(B);
                                lineList.remove(C);
                                exist2 = true;
                                break;
                            }else{//CA同省
                                if(B.getECen().compareTo(C.getSCen())==0&&C.getEPro().compareTo(A.getSPro())==0&&C.getTType().compareTo(A.getTType())==0){
                                    sb3.append(A.getId()).append("+").append(B.getId()).append("+").append(C.getId());
                                    lineList.remove(A);
                                    lineList.remove(B);
                                    lineList.remove(C);
                                    exist3 = true;
                                    break;
                                }
                            }
                        }
                    }

                }
            }
        }

        result.add(sb1.toString());
        result.add(sb2.toString());
        result.add(sb3.toString());

        return result;
    }
    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
    }
}