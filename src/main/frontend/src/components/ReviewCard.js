
import '../styles/ReviewCard.css'
import React, {useState, useEffect} from 'react'
import { useParams } from "react-router-dom";
import { CarList } from "../helpers/CarList";
import '../styles/Review.css'
import ReviewTextArea from '../components/ReviewTextArea';
import axios from 'axios';



function ReviewCard({carName}) {
    const[reviews, setReviews] = useState([]);
    const[filteredReviews, setFilteredReviews] = useState([reviews]);
    let result = [];

    const fetchReviews = ()=>{
        axios.get("http://localhost:8080/api/v1/review").then(res=> {
        console.log(res);
        setReviews(res.data)
        ;
        });
    };
    
    useEffect(() =>{
        fetchReviews();
    }, []);


        return reviews.map((review,index) => {
            if(review.car == carName){
            return(<div>
                
                <div className='reviewCard'>
                <p>User: {review.user}</p>
                <p>Car: {review.car}</p>
                <p>Rating: {review.rating} / 5</p>
                <p>review: {review.review}</p>
                </div>

            </div>
            )}
        })

        // return reviews.map((review,index)=> {
        //     return(<ReviewCard
        //             username = {Reviews}
        //         />)
        // })
        // return (
        //     <div className='reviewCard'>
        //         <p>Username: {username}</p>
        //         <p>Rating: {rating}</p>
        //         <p>Comment: {comment}</p>
        //     </div>
        // )
}

export default ReviewCard
