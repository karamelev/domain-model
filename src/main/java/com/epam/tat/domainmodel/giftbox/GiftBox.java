package com.epam.tat.domainmodel.giftbox;

import com.epam.tat.domainmodel.candies.Candy;
import com.epam.tat.domainmodel.candies.CandyBase;
import com.epam.tat.domainmodel.util.Finding;
import com.epam.tat.domainmodel.util.Sorting;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Description:
 * Implement interfaces: Sorting and Finding and
 * their methods for sorting candies by name or weight and
 * finding candies by parameters.
 * <p>
 */
public class GiftBox implements Finding,Sorting{
    /**
     * No actions are required for class variable candiesList.
     */
    private List<Candy> candiesList;

    /**
     * No actions are required for constructor GiftBox().
     */
    public GiftBox() {
        candiesList = new ArrayList<Candy>();
    }


    /**
     * No actions are required for method addCandy().
     */
    public void addCandy(Candy candy) {
        this.candiesList.add(candy);
    }

    /**
     * Implement sorting of candiesList by its names in ascending order
     * and return sorted by name ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByNameAsc() {
        candiesList.sort(Comparator.comparing(Candy::getName));
        return candiesList;
//        throw new UnsupportedOperationException("You need to implement this method");
    }

    /**
     * Implement sorting of candiesList by its weight in ascending order
     * and return sorted by weight ascending list of candies.
     */
    @Override
    public List<Candy> sortCandiesByWeightAsc() {
        candiesList.sort(Comparator.comparing(Candy::getWeight));
        return candiesList;
//        throw new UnsupportedOperationException("You need to implement this method");
    }

    /**
     * Implement selection of candies from candiesList with names started with candyNameFirstLetter
     * and return list of candies which names started with candyNameFirstLetter in name ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByNameStartedWith(char candyNameFirstLetter) {

//        String regex = "^candyNameFirstLetter";
        List <Candy> candies = new ArrayList<Candy>();
        Pattern pattern = Pattern.compile("^" + candyNameFirstLetter);
        for (int i = 0; i < candiesList.size(); i++) {
//            Matcher matcher = pattern.matcher(candiesList.get(i).getName())
            if (pattern.matcher(candiesList.get(i).getName()).find()) {
                candies.add(candiesList.get(i));
            }
        }
//        Matcher matcher = pattern.find(candiesList.toString());
//        return candiesList;
        return candies;
    }

    /**
     * Implement selection ot candies from candiesList so that its [weightFrom <= weight => weightTo]
     * and return list of candies with weight in range [weightFrom, weightTo] in weight ascending list of candies.
     */
    @Override
    public List<Candy> findCandiesByWeightInRange(int weightFrom, int weightTo) {
        candiesList.sort(Comparator.comparing(Candy::getWeight));
        List <Candy> candies = new ArrayList<Candy>();
        for (int i = 0; i < candiesList.size(); i++) {
            if (candiesList.get(i).getWeight() >= weightFrom && candiesList.get(i).getWeight() <= weightTo) {
                candies.add(candiesList.get(i));
            }
        }
//        int fromIndex = candiesList.indexOf(weightFrom);
//        int toIndex = candiesList.indexOf(weightTo);
//        candiesList.subList(fromIndex,toIndex);
//        return candiesList;
        return candies;

//        throw new UnsupportedOperationException("You need to implement this method");
    }
}
