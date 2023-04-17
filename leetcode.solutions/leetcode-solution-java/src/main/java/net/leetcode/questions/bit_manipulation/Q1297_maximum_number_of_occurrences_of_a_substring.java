package net.leetcode.questions.bit_manipulation;

import java.util.HashSet;
import java.util.Set;
import net.leetcode.questions.array.Q0027_remove_element;

public class Q1297_maximum_number_of_occurrences_of_a_substring {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        int len = s.length();

        for (int i = minSize; i <= maxSize; i++) {
            for (int j = 0; j + i <= len; j++) {
                String subString = s.substring(j, j + i);

                Set<Character> set = new HashSet<>();
                for (Character character : subString.toCharArray()) {
                    set.add(character);
                }

                if (set.size() > maxLetters) {
                    continue;
                }

                res = Math.max(res, countAppear(s, len, subString, i));
            }
        }
        return res;
    }

    private int countAppear(String s, int sLen, String subString, int subLen) {
        int count = 0;
        for (int i = 0; i + subLen <= sLen; i++) {
            int index = s.indexOf(subString, i);
            if (index == -1){
                break;
            }
            if (index == i) {
                count += 1;
            }

        }
        return count;
    }


    public static void main(String[] args) {
//        String s = "aababcaab";
//        int maxLetters = 2;
//        int minSize = 3;
//        int maxSize = 4;

//        String s = "aaaa";
//        int maxLetters = 1;
//        int minSize = 3;
//        int maxSize = 3;


        String s = "babcbceccaaacddbdaedbadcddcbdbcbaaddbcabcccbacebda";
        int maxLetters = 1;
        int minSize = 1;
        int maxSize = 1;

//        String s = "abcde";
//        int maxLetters = 2;
//        int minSize = 3;
//        int maxSize = 3;

//        String s = "ffhrimojtdwnwrwsmwxxprahdofmwzzcziskfyxvlteunhyjvmexcbxlrxtcsozrxyaxppdztpzqfcnpiwzhcvyyvpnlwwkhjlctlsbboosvyabdglhzvwdtazcyrumynkhqywrmyljhkxbpnwmfkxnqpchyjckwwpiqjljynsidcccffguyqmvnubgznsjzgkublxwvdjequsguchpzcfncervajafyhyjvoqetaxkybvqgbglmcoxxapmymxmmsqpddpctymxkkztnpiqcgrsybfrqzepnteiuzkvfnnfwsjwrshjclvkvjiwfqbvprbknvxotekxskjofozxiisnomismymubikpagnvgrchynsyjmwadhqzbfssktjmdkbztodwidpwbihfguxzgrjsuksfjuxfqvmqqojoyjznvoktfbwykwhaxorlduchkefnbpgknyoodaizarigbozvsikhxhokfpedydzxlcbasrxnenxrqxgkyfncgnhmbtxnigznqaawmslxehbshmelgfxaayttbsbhvrpsehituihvleityqckpfpmcjffhhgxdprsylnjvrezjdwjrzgqbdwdctfnvibhgcpmudxnoedfgejnbctrcxcvresawrgpvmgptwnwudqfdpqiokqbujzkalfwddfpeptqhewwrlrwdabafodecuxtoxgcsbezhkoceyydjkniryftqdoveipatvfrfkhdztibywbajknxvkrcvfhgbnjxnoefgdwbekrvaalzuwypkhwhmxtnmoggsogczhemzysagznnmjiiwwyekibytqhgwfzmsqlntvakyhaaxiqvlxbhgknvdxjwecccsquqqqmrxsysfyidsbtqytgonmzyjcydyqqqmixrbrllbcbbnwvriqcrznobzippyssjypvjemvadgdcriydntlpyrmxejtdyzhzdljhbyifxewdyokbhcgkhpdjoeqexfxqwvxys";
        Q0027_remove_element solution = new Q0027_remove_element();
//        int maxLetters = 18;
//        int minSize = 2;
//        int maxSize = 2;


//        String s = "cgsdtiimjiwsstocjsquzkkpmjvkbdivdaxooxxnexifikdrygdmelbhqeejrsvcwgggqrgfdzwlzdgjozuvldhmaihamsxzkkxigxvmfpictheeihqovuhisorwjdxdzhnalmujobxsecoiuqducqredrwnlskxooouyndqpinamsnusnpjhbayhhktklfsawaawbxwkqxfmzwootnzhxdtflcmdqeyidjcdasbpfrzcsiqzsvvryosrnkuisvdudiyfgcsmygoyccgndtomrsyiebaqqkssjusnwaxaaxxjqsmmefhlbstqcxxiejtdsqrsmcuablbrimgzghjhdvlheiyyydvkxkenrdprtrxszrjbeofabhjuhqduvsapknaiaiyxppayfbuocjwzphutsscgbjkdtnszudxrciejfykyeorpodzeatiuusjqyllcasximwjfspqdeutxlenebpbcsbnojxqqpiwjexqkkqvkdrefbbtyjqjvbyitygbxtodpucoxouewauwftppfowtlarjoftnbblsxrwcbshssamdcosmvebsywatuiluljqddeccwaclrkeyzqiczvsoqoruvpfcjcichbmssttpktctwzrurmrbrvlbowuwmkisindrvctifmdwjovfjbimjdjqumrravuqhvyxruakfraydpaumprvmquixklbfwanzyfkuyoqxzvwgoreuhrdiilirsfffpbbidhlmcjmlkcjvoxabadfmxuahuktaivuwawcndbkmcprrjyitwithysrjyhjjlycobgacpveoukgvrbkteftffslrkveympxxyettrwwvnoxemnrjromtizcoygmktdiwudtmwnsdocbfoeoldytqhhiqjpydiewnyyvsashckyxiobrxidnwgjvekzkqotzlojlbguaxbfhdeesjelbbzdphwyawpycdigoavtxcmhjdosxkzfyckdymrcasnbh";
//        int maxLetters = 6;
//        int minSize = 8;
//        int maxSize = 26;
        int res = solution.maxFreq(s, maxLetters, minSize, maxSize);
        System.out.println("res " + res);


    }
}
