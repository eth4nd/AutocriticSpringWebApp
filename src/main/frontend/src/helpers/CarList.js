//Test cars and reviews
import Honda from '../assets/2022_Honda_Civic_Type_R.jpg';
import Tesla from '../assets/2022-tesla-model-3.jpg';
import Toyota from '../assets/2022_toyota_camry.jpg';
import Mercedes from '../assets/2022-mercedes-benz-c-class.jpg';

export const CarList = [
    {
        name: '2022 Honda Civic Type-R',
        image: Honda,
        price: 21700,
        reviews: [
            {
                uuid: 1234,
                username: "john",
                rating: 1,
                comment: "dumb car"
            },
            // {
            //     uuid: 5678,
            //     username: "bob",
            //     rating: 5,
            //     comment: "good car"
            // },
            // {
            //     uuid: 1111,
            //     username: "mike",
            //     rating: 3,
            //     comment: "decent car"
            // }
        ]
    },
    {
        name: '2022 Tesla Model 3',
        image: Tesla,
        price: 43990,
        reviews: [
            {
                uuid: 4444,
                username: "josef",
                rating: 5,
                comment: "nice car"
            }
        ]
    },
    {
        name: '2022 Toyota Camry',
        image: Toyota,
        price: 25295,
        reviews: [
            {
                uuid: 3333,
                username: "remy",
                rating: 5,
                comment: "nice car"
            }
        ]
    },
    {
        name: '2022 Mercedes-Benz C-Class',
        image: Mercedes,
        price: 42000,
        reviews: [
            {
                uuid: 2323,
                username: "thom",
                rating: 1,
                comment: "bad car"
            }
        ]
    }
]