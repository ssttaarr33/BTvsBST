package algorhytms;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortHotels {

    public static void main(String[] args) {
        String words = "breakfast beach citycenter location metro view staff price";
        List<Hotel> ratings = new ArrayList<>();
        ratings.add(new Hotel(1, Arrays.asList("This hotel has a nice view of the citycenter. The location is perfect",
                "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.",
                "They said I couldn't take my dog and there were other guests with dogs! That is not fair.")));
        ratings.add(new Hotel(2, Arrays.asList("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.",
                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.")));

        List<HotelRating> hotelRatings = sortHotels(words, ratings);
        hotelRatings.stream().forEach(hotel -> System.out.println(hotel.id));
    }

    public static List<HotelRating> sortHotels(String keyWords, List<Hotel> ratingReviews) {
        String[] keyWordsArray = keyWords.split(" ");
        return ratingReviews.stream().map(hotel -> {
            long wordsMatch = hotel.getReviews().stream()
                    .flatMap(review -> Arrays.stream(review.split(" ")))
                    .map(word -> word.replaceAll("[.,]", ""))
                    .filter(word -> Arrays.asList(keyWordsArray).contains(word.toLowerCase()))
                    .count();
            return new HotelRating(hotel.getId(), wordsMatch);
        }).sorted().collect(Collectors.toList());
    }

    @AllArgsConstructor
    @Data
    static
    class Hotel {
        int id;
        List<String> reviews;

    }

    @AllArgsConstructor
    @Data
    static
    class HotelRating implements Comparable<HotelRating> {
        int id;
        long count;

        @Override
        public int compareTo(HotelRating hotelRating) {
            if (hotelRating.count - count != 0) {
                return hotelRating.count - count > 0 ? 1 : -1;
            }
            return id - hotelRating.id;
        }
    }

}
