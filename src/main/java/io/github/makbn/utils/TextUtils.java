package io.github.makbn.utils;

import java.util.HashMap;

/**
 * Mehdi AKbarian-astaghi 8/11/19
 */
public class TextUtils {

    private static HashMap<Integer, String> texts = new HashMap<>();

    static {
        texts.put(1,"Ok");
        texts.put(2,"Ok then");
        texts.put(3,"what the fuck");
        texts.put(5,"so high down am week");
        texts.put(10,"Denote simple fat denied add worthy little use.");
        texts.put(20,"As some he so high down am week. Conduct esteems by cottage to pasture we winding. ");
        texts.put(30, "On assistance he cultivated considered frequently. Person how having tended direct own day man. " +
                "Saw sufficient indulgence one own you inquietude sympathize.");
        texts.put(40,"An valley indeed so no wonder future nature vanity. " +
                "Debating all she mistaken indulged believed provided declared. " +
                "He many kept on draw lain song as same. " +
                "Whether at dearest certain spirits is entered in to.");

        texts.put(50, "Rich fine bred real use too many good. " +
                "She compliment unaffected expression favourable any. " +
                "Unknown chiefly showing to conduct no. Hung as love evil able to post at as." +
                "owever venture pursuit he am mr cordial." +
                "Forming musical am hearing studied be luckily. " +
                "Valley afford uneasy joy she thrown though bed set");

        texts.put(0,"Left till here away at to whom past. Feelings laughing at no wondered repeated provided finished. It acceptance thoroughly my advantages everything as. Are projecting inquietude affronting preference saw who. Marry of am do avoid ample as. Old disposal followed she ignorant desirous two has. Called played entire roused though for one too. He into walk roof made tall cold he. Feelings way likewise addition wandered contempt bed indulged. \n" +
                "\n" +
                "She wholly fat who window extent either formal. Removing welcomed civility or hastened is. Justice elderly but perhaps expense six her are another passage. Full her ten open fond walk not down. For request general express unknown are. He in just mr door body held john down he. So journey greatly or garrets. Draw door kept do so come on open mean. Estimating stimulated how reasonably precaution diminution she simplicity sir but. Questions am sincerity zealously concluded consisted or no gentleman it. \n" +
                "\n" +
                "Scarcely on striking packages by so property in delicate. Up or well must less rent read walk so be. Easy sold at do hour sing spot. Any meant has cease too the decay. Since party burst am it match. By or blushes between besides offices noisier as. Sending do brought winding compass in. Paid day till shed only fact age its end. \n" +
                "\n" +
                "Style never met and those among great. At no or september sportsmen he perfectly happiness attending. Depending listening delivered off new she procuring satisfied sex existence. Person plenty answer to exeter it if. Law use assistance especially resolution cultivated did out sentiments unsatiable. Way necessary had intention happiness but september delighted his curiosity. Furniture furnished or on strangers neglected remainder engrossed. \n" +
                "\n" +
                "Cultivated who resolution connection motionless did occasional. Journey promise if it colonel. Can all mirth abode nor hills added. Them men does for body pure. Far end not horses remain sister. Mr parish is to he answer roused piqued afford sussex. It abode words began enjoy years no do \uFEFFno. Tried spoil as heart visit blush or. Boy possible blessing sensible set but margaret interest. Off tears are day blind smile alone had. " );

    }


    public static String getRandom(int len){
        if(len == 0 || len > 60)
            return texts.get(0);
        else if(len < 2)
            return texts.get(1);
        else if(len < 3)
            return texts.get(2);
        else if(len < 4)
            return texts.get(3);
        else if(len < 5)
            return texts.get(4);
        else if(len < 10)
            return texts.get(5);
        else if(len < 20)
            return texts.get(10);
        else if(len < 30)
            return texts.get(20);
        else if(len < 40)
            return texts.get(30);
        else if(len < 50)
            return texts.get(40);
        else
            return texts.get(50);
    }
}
