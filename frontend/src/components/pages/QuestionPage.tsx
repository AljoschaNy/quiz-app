import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import {Question} from "../../types/types.ts";

function QuestionPage() {
    const {topicId} = useParams();
    const [questions, setQuestions] = useState<Question[]>()

    useEffect(() => {
        if(topicId) {
            axios.get<Question[]>("/api/questions/" + topicId)
                .then(response => setQuestions(response.data))
                .catch(error => console.log("error", error))
        }
    }, [topicId])

    return questions && (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <p className={"info-text"}>Question 6 of 10</p>
                <h2>{questions[0].query}</h2>
                <div className={"progress-bar"}></div>
            </section>

            <section className={"options-container"}>
            <p>{topicId}</p>
            </section>
        </main>
    );
}

export default QuestionPage;