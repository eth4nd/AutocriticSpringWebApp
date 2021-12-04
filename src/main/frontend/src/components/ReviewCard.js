
import '../styles/ReviewCard.css'
import React, {useState, useEffect} from 'react'
import { useParams } from "react-router-dom";
import { CarList } from "../helpers/CarList";
import '../styles/Review.css'
import ReviewTextArea from '../components/ReviewTextArea';
import axios from 'axios';



function ReviewCard({ username, rating, comment }) {
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
                <div className='reviewCard'>
                <p>User: {review.user}</p>
                <p>Car: {review.car}</p>
                <p>Rating: {review.rating}</p>
                <p>review: {review.review}</p>
                </div>

            </div>
            )
        })

        // return reviews.map((review,index)=> {
        //     return(<ReviewCard
        //             username = {Reviews}
        //         />)
        // })
    return (
        <div className='reviewCard'>
            <p>Username: {username}</p>
            <p>Rating: {rating}</p>
            <p>Comment: {comment}</p>
        </div>
    )
}

export default ReviewCard
