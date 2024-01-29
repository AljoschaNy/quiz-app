import TopicCard from "../main/TopicCard.tsx";
import {Topic} from "../../types/types.ts";
import {useEffect, useState} from "react";
import axios from "axios";

function StartPage() {
    const [topics, setTopics] = useState<Topic[]>([])

    useEffect(() => {
        axios.get<Topic[]>("/api/topics")
            .then(response => setTopics(response.data))
            .catch(error => console.log("error", error))
    }, [])

    return (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <h1><span className={"intro-text"}>Welcome to the</span> Frontend Quiz!</h1>
                <div className={"divider"}></div>
                <p className={"info-text"}>Pick a subject to get started.</p>
            </section>

            <section className={"options-container"}>
                {topics.map(topic => {
                    return <TopicCard key={topic.id} topic={topic}/>;
                })}
            </section>

        </main>
    );
}

export default StartPage;
