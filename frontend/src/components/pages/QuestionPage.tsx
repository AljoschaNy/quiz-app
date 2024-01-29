import {useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import {Question} from "../../types/types.ts";
import OptionCard from "../main/OptionCard.tsx";

function QuestionPage() {
    const {topicId} = useParams();
    const [questions, setQuestions] = useState<Question[]>()
    const [selectedOption, setSelectedOption] = useState<string | null>(null);
    const optionCount:string[] = ["A","B","C","D"];

    useEffect(() => {
        if(topicId) {
            axios.get<Question[]>("/api/questions/" + topicId)
                .then(response => setQuestions(response.data))
                .catch(error => console.log("error", error))
        }
    }, [topicId])

    function handleClick(option:string) {
        setSelectedOption(option);
    }

    function handleSubmit() {
        alert(selectedOption);
        setSelectedOption(null)
    }

    return questions && (
        <main className={"main-content"}>
            <section className={"info-section"}>
                <p className={"info-text"}>Question 6 of 10</p>
                <h2>{questions[0].query}</h2>
                <div className={"progress-bar"}></div>
            </section>

            <section className={"options-container"}>
                {
                    questions[0].options.map((option, index) => {
                    return <OptionCard
                        key={questions[0]+option}
                        optionCount={optionCount[index]}
                        optionText={option}
                        isSelected={selectedOption === option}
                        onClick={() => handleClick(option)}
                    />
                })}
                <button className={"option-select"} onClick={handleSubmit}>Submit Answer</button>
            </section>
        </main>
    );
}

export default QuestionPage;