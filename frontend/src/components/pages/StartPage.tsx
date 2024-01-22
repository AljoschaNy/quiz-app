import MainContent from "../main/MainContent.tsx";
import {Topic} from "../../types/types.ts";
import {useEffect, useState} from "react";
import axios from "axios";

function StartPage() {
    const [topics, setTopics] = useState<Topic[]>([])

    useEffect(() => {
        axios.get("/api/topics")
            .then(response => setTopics(response.data))
            .catch(error => console.log("error", error))
    })

    return (
        <MainContent topics={topics} />
    );
}

export default StartPage;
