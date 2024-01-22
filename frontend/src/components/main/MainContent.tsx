import "./MainContent.css";
import OptionCard from "./OptionCard.tsx";
import {MainContentType} from "../../types/types.ts";

function MainContent( {topics}:Readonly<MainContentType> ) {

    return (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <h1><span className={"intro-text"}>Welcome to the</span> Frontend Quiz!</h1>
                <p className={"info-text"}>Pick a subject to get started.</p>
            </section>

            <section className={"options-container"}>
                {topics.map(topic => {
                    return <OptionCard key={topic.id} topic={topic}/>;
                })}
            </section>

        </main>
    );
}

export default MainContent;
