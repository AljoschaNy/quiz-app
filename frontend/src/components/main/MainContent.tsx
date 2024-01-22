import StartPage from "../pages/StartPage.tsx";
import {Topic} from "../../types/types.ts";
import {useEffect, useState} from "react";
import axios from "axios";

function MainContent() {
    const [topics, setTopics] = useState<Topic[]>([])

    useEffect(() => {
        axios.get<Topic[]>("/api/topics")
            .then(response => setTopics(response.data))
            .catch(error => console.log("error", error))
    }, [])

    return (
        <StartPage topics={topics}/>
    );
}

export default MainContent;
