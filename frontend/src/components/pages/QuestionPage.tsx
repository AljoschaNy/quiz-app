import {useParams} from "react-router-dom";
import {useEffect} from "react";
import axios from "axios";

function QuestionPage() {
    const {topicId} = useParams();

    useEffect(() => {
        if(topicId) {
            axios.get("/api/questions/" + topicId)
                .then(response => console.log(response.data))
                .catch(error => console.log(error))
        }
    }, [topicId])

    return (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <h1>Question Page</h1>
                <p className={"info-text"}>Pick a subject to get started.</p>
            </section>

            <section className={"options-container"}>
                <p>{topicId}</p>
            </section>
        </main>
    );
}

export default QuestionPage;