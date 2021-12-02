import React from 'react'
import '../styles/ReviewCard.css'

function ReviewCard({ username, rating, comment }) {
    return (
        <div className='reviewCard'>
            <p>Username: {username}</p>
            <p>Rating: {rating}</p>
            <p>Comment: {comment}</p>
        </div>
    )
}

export default ReviewCard
