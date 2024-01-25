import StartPage from "../pages/StartPage.tsx";
import {Topic} from "../../types/types.ts";
import {useEffect, useState} from "react";
import axios from "axios";
import QuestionPage from "../pages/QuestionPage.tsx";
import {Route, Routes} from "react-router-dom";

function MainContent() {
    const [topics, setTopics] = useState<Topic[]>([])

    useEffect(() => {
        axios.get<Topic[]>("/api/topics")
            .then(response => setTopics(response.data))
            .catch(error => console.log("error", error))
    }, [])

    return (
        <>
            <Routes>
                <Route path={"/"} element={<StartPage topics={topics}/>} />
                <Route path={"/question/:topicId"} element={<QuestionPage />} />
            </Routes>
        </>

    );
}

export default MainContent;
