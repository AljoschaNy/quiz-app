import "./StartPage.css";
import OptionCard from "../main/OptionCard.tsx";
import {StartPageType} from "../../types/types.ts";

function StartPage({topics}:Readonly<StartPageType> ) {

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

export default StartPage;
