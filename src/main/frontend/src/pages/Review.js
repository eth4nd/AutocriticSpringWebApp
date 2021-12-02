import React, {useState, useEffect} from 'react'
import { useParams } from "react-router-dom";
import { CarList } from "../helpers/CarList";
import ReviewCard from "../components/ReviewCard";
import '../styles/Review.css'
import ReviewTextArea from '../components/ReviewTextArea';
import axios from 'axios';


const Reviews = () => {
    const[reviews, setReviews] = useState([]);
    
        const fetchReviews = ()=>{
            axios.get("http://localhost:8080/api/v1/review").then(res=> {
                console.log(res);
                setReviews(res.data);
            });
        };
    
        useEffect(() =>{
            fetchReviews();
        }, []);

        return reviews.map((review,index) => {
            return(<div key = {index}>
                <h1>Car Name: {review.car}</h1>
                <h1>{review.rating}</h1>
            </div>
            )
        })

        // return reviews.map((review,index)=> {
        //     return(<ReviewCard
        //             username = {Reviews}
        //         />)
        // })
}

function Review() {
    // retrieves name parameter from Router and searches in CarList for car with matching name
    const { name } = useParams()
    const car = CarList.find(c => c.name === name)
    

    return (
        <div className='review'>
            <div className='headerContainer'>
                <p>You are at the Review page</p>
                <h1>A review menu will be here</h1>
                <Reviews />
                <ReviewTextArea/>
            </div>
            <div className='carContainer'>
                <div style={{backgroundImage:`url(${car.image})`}} className='carImage'/>
                <h1>{car.name}</h1>
                <h2>MSRP: ${car.price.toLocaleString()}</h2>
            </div>
            <div className='reviewsContainer'>
                <h1>Reviews: </h1>
                {car.reviews.map((review) => {
                    return (
                        <ReviewCard

                            username={review.username}
                            rating={review.rating}
                            comment={review.comment}
                        />
                    )
                })}
            </div>

        </div>
    )
}

export default Review;

