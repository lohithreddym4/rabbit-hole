package com.hole.rabbit.config;

import com.hole.rabbit.concept.model.*;
import com.hole.rabbit.concept.repository.ConceptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Profile("dev")
@Configuration
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final ConceptRepository repo;

    @Override
    @Transactional // Note: Mongo transactions need a replica set (even for local dev you can init a single-node replica set)
    public void run(String... args) throws Exception {

        if (repo.count() > 0) return;

        // ----- create raw concept objects (no linking yet) -----
        Concept gravity = Concept.builder()
                .title("Gravity")
                .coreInsight("Mass bends spacetime, and that curvature guides motion.")
                .whyItMatters("Explains planets, stars, black holes — basically cosmic architecture.")
                .difficulty(2)
                .gravityScore(0.95)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("If gravity vanished for 5 seconds, what survives?")
                .build();

        Concept relativity = Concept.builder()
                .title("General Relativity")
                .coreInsight("Gravity is geometry.")
                .whyItMatters("GPS works only because Einstein was annoyingly correct.")
                .difficulty(4)
                .gravityScore(0.98)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is spacetime a thing… or a description?")
                .build();

        Concept tensor = Concept.builder()
                .title("Tensor Calculus")
                .coreInsight("Math that survives coordinate changes.")
                .whyItMatters("Without it, relativity collapses into confusion.")
                .difficulty(5)
                .gravityScore(0.99)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is mathematics invented or discovered?")
                .build();

        Concept newton = Concept.builder()
                .title("Newtonian Mechanics")
                .coreInsight("Forces create acceleration.")
                .whyItMatters("Still runs 90% of engineering.")
                .difficulty(2)
                .gravityScore(0.90)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Why does classical physics feel so intuitive?")
                .build();

        Concept quantum = Concept.builder()
                .title("Quantum Mechanics")
                .coreInsight("At tiny scales, probabilities replace certainties.")
                .whyItMatters("Underpins semiconductors, chemistry, and weird thought experiments.")
                .difficulty(5)
                .gravityScore(0.97)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Does the wavefunction collapse, or do we?")
                .build();

        Concept qmInterpretations = Concept.builder()
                .title("Interpretations of QM")
                .coreInsight("Multiple frameworks to explain the same math: Copenhagen, Many-worlds, Bohm...")
                .whyItMatters("Shapes how physicists and philosophers think about reality.")
                .difficulty(5)
                .gravityScore(0.85)
                .status(ConceptStatus.DRAFT)
                .provocativeQuestion("Are parallel worlds a feature or a bug?")
                .build();

        Concept thermodynamics = Concept.builder()
                .title("Thermodynamics")
                .coreInsight("Energy flows and entropy govern macroscopic change.")
                .whyItMatters("From engines to biology, it's the language of heat and work.")
                .difficulty(3)
                .gravityScore(0.92)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is entropy a measure of ignorance or reality?")
                .build();

        Concept statMech = Concept.builder()
                .title("Statistical Mechanics")
                .coreInsight("Microscopic randomness produces macroscopic laws.")
                .whyItMatters("Explains thermodynamics from atoms and probabilities.")
                .difficulty(5)
                .gravityScore(0.93)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Do laws emerge from statistics or do we force patterns?")
                .build();

        Concept electromagnetism = Concept.builder()
                .title("Electromagnetism")
                .coreInsight("Electric and magnetic fields are two faces of the same coin.")
                .whyItMatters("Everything from radios to light depends on Maxwell's equations.")
                .difficulty(3)
                .gravityScore(0.94)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is light a wave, a particle, or just very well-behaved math?")
                .build();

        Concept optics = Concept.builder()
                .title("Optics")
                .coreInsight("Light propagation, interference, and imaging: practical and elegant.")
                .whyItMatters("Cameras, glasses, fiber communication — applied electromagnetism.")
                .difficulty(3)
                .gravityScore(0.80)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("How much of reality do our eyes invent for us?")
                .build();

        Concept evolution = Concept.builder()
                .title("Evolution")
                .coreInsight("Descent with modification through variation and selection.")
                .whyItMatters("Explains biodiversity, disease dynamics, and human origins.")
                .difficulty(3)
                .gravityScore(0.96)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("If environment changes faster than evolution, who adapts?")
                .build();

        Concept naturalSelection = Concept.builder()
                .title("Natural Selection")
                .coreInsight("Differential survival and reproduction shapes traits.")
                .whyItMatters("The engine that sculpts life without a planner.")
                .difficulty(3)
                .gravityScore(0.95)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is cooperation an evolutionary accident or inevitability?")
                .build();

        Concept genetics = Concept.builder()
                .title("Genetics")
                .coreInsight("DNA encodes the structure and function of living systems.")
                .whyItMatters("From disease to inheritance and biotech, it's central to biology.")
                .difficulty(4)
                .gravityScore(0.94)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("How much of 'you' is code vs. context?")
                .build();

        Concept molecularBiology = Concept.builder()
                .title("Molecular Biology")
                .coreInsight("Cellular machinery expressed through molecules and interactions.")
                .whyItMatters("Drives modern medicine, biotech, and synthetic biology.")
                .difficulty(5)
                .gravityScore(0.91)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Can we design life the way we design software?")
                .build();

        Concept neuroplasticity = Concept.builder()
                .title("Neuroplasticity")
                .coreInsight("Brains rewire in response to experience.")
                .whyItMatters("Learning, recovery after injury, and habit change depend on it.")
                .difficulty(4)
                .gravityScore(0.78)
                .status(ConceptStatus.DRAFT)
                .provocativeQuestion("Are memories stored or continuously reconstructed?")
                .build();

        Concept computerScience = Concept.builder()
                .title("Computer Science")
                .coreInsight("Abstractions for computation, data, and algorithms.")
                .whyItMatters("Foundational to modern tech and automation.")
                .difficulty(3)
                .gravityScore(0.89)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is computation a tool or a new lens on reality?")
                .build();

        Concept algorithms = Concept.builder()
                .title("Algorithms")
                .coreInsight("Recipes for transforming inputs into useful outputs efficiently.")
                .whyItMatters("Optimizes everything from search to logistics.")
                .difficulty(4)
                .gravityScore(0.88)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is elegance in code aesthetic or performance?")
                .build();

        Concept dataStructures = Concept.builder()
                .title("Data Structures")
                .coreInsight("Ways to organize data to make algorithms faster and simpler.")
                .whyItMatters("Underpins performance and maintainability.")
                .difficulty(3)
                .gravityScore(0.86)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Can a structure shape the thinking of the programmer?")
                .build();

        Concept machineLearning = Concept.builder()
                .title("Machine Learning")
                .coreInsight("Statistical models ingest data to predict and act.")
                .whyItMatters("Powering personalization, automation, and pattern discovery.")
                .difficulty(5)
                .gravityScore(0.95)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Is a model that predicts behavior actually 'understanding' it?")
                .build();

        Concept calculus = Concept.builder()
                .title("Calculus")
                .coreInsight("Tools for change: derivatives and integrals.")
                .whyItMatters("Essential for physics, engineering, and many algorithms.")
                .difficulty(4)
                .gravityScore(0.87)
                .status(ConceptStatus.PUBLISHED)
                .provocativeQuestion("Did calculus reveal the universe or our way to describe it?")
                .build();

        // persist all seeds so IDs are generated
        List<Concept> seeds = List.of(
                gravity, relativity, tensor, newton,
                quantum, qmInterpretations, thermodynamics, statMech,
                electromagnetism, optics, evolution, naturalSelection,
                genetics, molecularBiology, neuroplasticity, computerScience,
                algorithms, dataStructures, machineLearning, calculus
        );

        repo.saveAll(seeds);

        // ----- ensure lists are initialized to prevent NPEs during traversal -----
        seeds.forEach(this::ensureLists);

        // ----- create robust links (reciprocal where appropriate) -----
        // Physics cluster
        linkDeeper(gravity, relativity);         // gravity -> relativity ; relativity.origin += gravity
        linkDeeper(relativity, tensor);          // relativity -> tensor ; tensor.origin += relativity
        linkDeeper(newton, gravity);             // newton -> gravity ; gravity.origin += newton
        linkDeeper(newton, calculus);            // newton -> calculus ; calculus.origin += newton
        linkDeeper(tensor, calculus);            // tensor -> calculus ; calculus.origin += tensor

        // Quantum cluster
        linkDeeper(quantum, qmInterpretations);
        linkOrigin(quantum, calculus);
        linkOrigin(quantum, newton);

        // Thermo cluster
        linkDeeper(thermodynamics, statMech);
        linkOrigin(thermodynamics, calculus);

        // EM & Optics
        linkDeeper(electromagnetism, optics);
        linkOrigin(electromagnetism, calculus);
        linkOrigin(electromagnetism, newton);

        // Biology cluster
        linkDeeper(evolution, naturalSelection);
        linkDeeper(naturalSelection, genetics);
        linkDeeper(genetics, molecularBiology);
        linkOrigin(naturalSelection, evolution);
        linkOrigin(genetics, calculus);
        linkOrigin(neuroplasticity, genetics);
        linkOrigin(neuroplasticity, molecularBiology);

        // CS cluster
        linkDeeper(computerScience, algorithms);
        linkDeeper(computerScience, dataStructures);
        linkOrigin(computerScience, calculus);
        linkOrigin(machineLearning, statMech);
        linkOrigin(machineLearning, algorithms);

        // Lateral / wider links (encourage cross-pollination, avoids deep-only chains)
        linkWider(calculus, algorithms);
        linkWider(algorithms, machineLearning);
        linkWider(statMech, machineLearning);
        linkWider(thermodynamics, evolution);
        linkWider(electromagnetism, optics);
        linkWider(computerScience, machineLearning);
        linkWider(evolution, genetics);

        // ----- final save of updated relationships -----
        repo.saveAll(seeds);
    }

    // ---------- helpers ----------

    private void ensureLists(Concept c) {
        if (c == null) return;
        if (c.getDeeper() == null) c.setDeeper(new ArrayList<>());
        if (c.getWider() == null) c.setWider(new ArrayList<>());
        if (c.getOrigin() == null) c.setOrigin(new ArrayList<>());
        if (c.getFailure() == null) c.setFailure(new ArrayList<>());
    }

    /**
     * Link parent -> child as DEEPER, and reciprocally add parent as an ORIGIN of child.
     */
    private void linkDeeper(Concept parent, Concept child) {
        if (parent == null || child == null) return;
        ensureLists(parent);
        ensureLists(child);

        if (!containsId(parent.getDeeper(), child.getId())) {
            parent.getDeeper().add(child.getId());
        }
        if (!containsId(child.getOrigin(), parent.getId())) {
            child.getOrigin().add(parent.getId());
        }
    }

    /**
     * Add a WIDER (lateral) connection between a and b (symmetric).
     */
    private void linkWider(Concept a, Concept b) {
        if (a == null || b == null) return;
        ensureLists(a);
        ensureLists(b);

        if (!containsId(a.getWider(), b.getId())) {
            a.getWider().add(b.getId());
        }
        if (!containsId(b.getWider(), a.getId())) {
            b.getWider().add(a.getId());
        }
    }

    /**
     * Explicitly mark origin relationship: parent -> originChild means parent.origin contains originChild.id
     * (Used when the conceptual relationship reads better that way.)
     */
    private void linkOrigin(Concept parent, Concept originChild) {
        if (parent == null || originChild == null) return;
        ensureLists(parent);
        ensureLists(originChild);

        if (!containsId(parent.getOrigin(), originChild.getId())) {
            parent.getOrigin().add(originChild.getId());
        }
        // Optionally maintain reciprocal deeper link if you want that behavior:
        if (!containsId(originChild.getDeeper(), parent.getId())) {
            originChild.getDeeper().add(parent.getId());
        }
    }

    private boolean containsId(List<String> list, String id) {
        if (list == null || id == null) return false;
        return list.stream().anyMatch(s -> Objects.equals(s, id));
    }
}
