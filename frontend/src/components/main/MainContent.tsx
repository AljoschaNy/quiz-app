import "./MainContent.css";
import StartPage from "../pages/StartPage.tsx";
import QuestionPage from "../pages/QuestionPage.tsx";
import {Route, Routes} from "react-router-dom";

function MainContent() {
    return (
        <Routes>
                <Route path={"/"} element={<StartPage />} />
                <Route path={"/question/:topicId"} element={<QuestionPage />} />
        </Routes>
    );
}

export default MainContent;
