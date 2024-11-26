import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectibleListTest {
    CollectibleList allValidCollectibles;
    CollectibleList emptyCollectibles;
    CollectibleList sameDifferenceCollectibles;
    CollectibleList fewerCollectibles;
    CollectibleList nullYearCollectibles;
    CollectibleList smallAndLargeDifferencesCollectibles;
    CollectibleList negativeDifferenceCollectibles;

    @BeforeEach
    void init() {
        // list of five valid collectibles
        allValidCollectibles = new CollectibleList();
        EstimatedYear estimatedYearOne = new EstimatedYear(1900, 1950);
        Collectible validCollectibleOne = new Book("1984","Second","Fiction", "George Orwell", estimatedYearOne, "C5", Collectible.ConditionType.MINT, 100, 1);
        allValidCollectibles.addOneCollectible(validCollectibleOne);
        EstimatedYear estimatedYearTwo = new EstimatedYear(2000, 2005);
        Collectible validCollectibleTwo = new Book("1984","Second","Fiction", "George Orwell", estimatedYearTwo, "C5", Collectible.ConditionType.MINT, 100, 2);
        allValidCollectibles.addOneCollectible(validCollectibleTwo);
        EstimatedYear estimatedYearThree = new EstimatedYear(1950, 1990);
        Collectible validCollectibleThree = new Book("1984","Second","Fiction", "George Orwell", estimatedYearThree, "C5", Collectible.ConditionType.MINT, 100, 3);
        allValidCollectibles.addOneCollectible(validCollectibleThree);
        EstimatedYear estimatedYearFour = new EstimatedYear(1980, 2005);
        Collectible validCollectibleFour = new Book("1984","Second","Fiction", "George Orwell", estimatedYearFour, "C5", Collectible.ConditionType.MINT, 100, 4);
        allValidCollectibles.addOneCollectible(validCollectibleFour);
        EstimatedYear estimatedYearFive = new EstimatedYear(2000, 2010);
        Collectible validCollectibleFive = new Book("1984","Second","Fiction", "George Orwell", estimatedYearFive, "C5", Collectible.ConditionType.MINT, 100, 5);
        allValidCollectibles.addOneCollectible(validCollectibleFive);

        // list of three valid collectibles
        fewerCollectibles = new CollectibleList();
        fewerCollectibles.addOneCollectible(validCollectibleOne);
        fewerCollectibles.addOneCollectible(validCollectibleTwo);

        // empty list
        emptyCollectibles = new CollectibleList();

        // all collectibles with the same difference
        sameDifferenceCollectibles = new CollectibleList();
        EstimatedYear estimatedYearSix = new EstimatedYear(2000, 2010);
        Collectible validCollectibleSix = new Book("1984","Second","Fiction", "George Orwell", estimatedYearSix, "C5", Collectible.ConditionType.MINT, 100, 6);
        sameDifferenceCollectibles.addOneCollectible(validCollectibleSix);
        EstimatedYear estimatedYearSeven = new EstimatedYear(2005, 2015);
        Collectible validCollectibleSeven = new Book("1984","Second","Fiction", "George Orwell", estimatedYearSeven, "C5", Collectible.ConditionType.MINT, 100, 7);
        sameDifferenceCollectibles.addOneCollectible(validCollectibleSeven);
        EstimatedYear estimatedYearEight = new EstimatedYear(2010, 2020);
        Collectible validCollectibleEight = new Book("1984","Second","Fiction", "George Orwell", estimatedYearEight, "C5", Collectible.ConditionType.MINT, 100, 8);
        sameDifferenceCollectibles.addOneCollectible(validCollectibleEight);

        // list of collectibles with one collectible's year set to null
        nullYearCollectibles = new CollectibleList();
        EstimatedYear estimatedYearNine = new EstimatedYear(2000, 2010);
        Collectible validCollectibleNine = new Book("1984","Second","Fiction", "George Orwell", estimatedYearNine, "C5", Collectible.ConditionType.MINT, 100, 9);
        nullYearCollectibles.addOneCollectible(validCollectibleNine);
        Collectible validCollectibleTen = new Book("1984","Second","Fiction", "George Orwell", null, "C5", Collectible.ConditionType.MINT, 100, 10);
        nullYearCollectibles.addOneCollectible(validCollectibleTen);
        EstimatedYear estimatedYearEleven = new EstimatedYear(2010, 2024);
        Collectible validCollectibleEleven = new Book("1984","Second","Fiction", "George Orwell", estimatedYearEleven, "C5", Collectible.ConditionType.MINT, 100, 11);
        nullYearCollectibles.addOneCollectible(validCollectibleEleven);

        // list of collectibles with small and large differences in years
        smallAndLargeDifferencesCollectibles = new CollectibleList();
        EstimatedYear estimatedYearTwelve = new EstimatedYear(2010, 2010);
        Collectible validCollectibleTwelve = new Book("1984","Second","Fiction", "George Orwell", estimatedYearTwelve, "C5", Collectible.ConditionType.MINT, 100, 12);
        smallAndLargeDifferencesCollectibles.addOneCollectible(validCollectibleTwelve);
        EstimatedYear estimatedYearThirteen = new EstimatedYear(1000, 3000);
        Collectible validCollectibleThirteen = new Book("1984","Second","Fiction", "George Orwell", estimatedYearThirteen, "C5", Collectible.ConditionType.MINT, 100, 13);
        smallAndLargeDifferencesCollectibles.addOneCollectible(validCollectibleThirteen);
        EstimatedYear estimatedYearFourteen = new EstimatedYear(1990, 2000);
        Collectible validCollectibleFourteen = new Book("1984","Second","Fiction", "George Orwell", estimatedYearFourteen, "C5", Collectible.ConditionType.MINT, 100, 14);
        smallAndLargeDifferencesCollectibles.addOneCollectible(validCollectibleFourteen);

        // list of collectibles with a negative differences in years
        negativeDifferenceCollectibles = new CollectibleList();
        EstimatedYear estimatedYearFifteen = new EstimatedYear(2024, 2019);
        Collectible validCollectibleFifteen = new Book("1984","Second","Fiction", "George Orwell", estimatedYearFifteen, "C5", Collectible.ConditionType.MINT, 100, 15);
        negativeDifferenceCollectibles.addOneCollectible(validCollectibleFifteen);
        EstimatedYear estimatedYearSixteen = new EstimatedYear(2000, 2020);
        Collectible validCollectibleSixteen = new Book("1984","Second","Fiction", "George Orwell", estimatedYearSixteen, "C5", Collectible.ConditionType.MINT, 100, 16);
        negativeDifferenceCollectibles.addOneCollectible(validCollectibleSixteen);
    }
}
